package Services;

import java.util.Random;

public class AccountService {
    public static String generateAccountNumber() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        
        // Generate 12 random digits
        for (int i = 0; i < 12; i++) {
            int randomNumber = rand.nextInt(10); // Generates a random digit between 0 and 9
            sb.append(randomNumber);
        }
        
        return sb.toString();
    }
    
    public static String generateCustomerId() {
        Random rand = new Random();
        StringBuilder sb = new StringBuilder();
        
        // Generate 8 random digits
        for (int i = 0; i < 8; i++) {
            int randomNumber = rand.nextInt(9); // Generates a random digit between 0 and 9
            sb.append(randomNumber);
        }
        
        return sb.toString();
    }
}
