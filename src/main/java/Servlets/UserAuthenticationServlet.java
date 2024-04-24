package Servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import Constants.MailConstant;
import Dao.ConnectionDb;
import Dao.LoginDao;
import Dao.RegisterDao;
import Model.User;
import Services.EmailUtility;
import Services.UserService;

public class UserAuthenticationServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String host;
	private String port;
	private String userEmail;
	private String pass;

	public void init() {
		// reads SMTP server setting from web.xml file
		ServletContext context = getServletContext();
		host = context.getInitParameter("host");
		port = context.getInitParameter("port");
		userEmail = context.getInitParameter("user");
		pass = context.getInitParameter("pass");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Connection con = ConnectionDb.getConnection(getServletContext());
		HttpSession session = request.getSession();

		String action = request.getParameter("action");
		// for registration
        if (action.equals("registration")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String role = request.getParameter("role");

            // Generate OTP
            String otp = UserService.generateOTPNumber(); 
            // Store user details and OTP in session
            session.setAttribute("user", new User(username, password, email, role));
            session.setAttribute("otp", otp);
            session.setAttribute("otpAttempts", 0);

            // Send OTP via email
            String subject = MailConstant.SUBJECT_OTP;
            String recipient = email;
            String content = MailConstant.MESSAGE_OTP + "\nOTP: " + otp;
            boolean emailSent = EmailUtility.sendEmail(host, port, userEmail, pass, recipient, subject, content);
            if (emailSent) {
                response.sendRedirect("otp.jsp");
            } else {
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.println("Failed to send OTP via email. Please try again.");
            }
        }
        
        // For OTP verification
        else if (action.equals("otp")) {
            String otpEntered = request.getParameter("otpNumber");
            String otpStored = (String) session.getAttribute("otp");
            int otpAttempts = (int) session.getAttribute("otpAttempts");
            
            if (otpEntered.equals(otpStored)) {
                // OTP matches, proceed with registration
                User user = (User) session.getAttribute("user");
                int rowResult = RegisterDao.register(user, con);
                if (rowResult > 0) {
                    session.removeAttribute("otp");
                    session.removeAttribute("user");
                    response.sendRedirect("login.jsp");
                } else {
                    PrintWriter out = response.getWriter();
                    response.setContentType("text/html");
                    out.println("Failed to register user. Please try again.");
                }
            } 
            else {
            	otpAttempts++;
                session.setAttribute("otpAttempts", otpAttempts);
                PrintWriter out = response.getWriter();
                response.setContentType("text/html");
                out.println("Please enter the correct otp");
                if (otpAttempts >= 3) {
                    // Three wrong attempts, redirect to registration
                    session.removeAttribute("otp");
                    session.removeAttribute("user");
                    response.sendRedirect("registration.jsp");
     
                }
            }
        }
		// for login
		else if (action.equals("login")) {

			String email = request.getParameter("email");
			String password = request.getParameter("password");

			User user = LoginDao.login(email, password, con);

			if (user != null) {

				session.setAttribute("userId", user.getUserId());
				session.setAttribute("Username", user.getUsername());
				session.setAttribute("userRole", user.getRole());
				session.setAttribute("email", user.getEmail());
				session.setAttribute("customerID", user.getCustomerId());
				
				String role = user.getRole();
				if (role.equals("admin")) {
					response.sendRedirect("admin");
				} else if (role.equals("user")) {

					response.sendRedirect("index.jsp");

				}

			}

			else {
				PrintWriter out = response.getWriter();
				response.setContentType("text/html");
				out.println("The Data is invalid");
			}

		}

	}

}
