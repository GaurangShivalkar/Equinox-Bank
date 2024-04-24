package Services;

import java.util.Random;

public class UserService {
    public static String generateOTPNumber() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        
        // Generate 4 random digits
        for (int i = 0; i < 4; i++) {
            int randomNumber = rand.nextInt(9); // Generates a random digit between 0 and 4
            sb.append(randomNumber);
        }
        
        return sb.toString();
    }
}
