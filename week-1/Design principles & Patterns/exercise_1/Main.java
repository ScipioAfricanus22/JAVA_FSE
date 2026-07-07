package exercise_1;

public class Main {
    public static void main(String[] args) {
        // Request the Logger instance for the first time
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message from logger1.");

        // Request the Logger instance a second time
        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message from logger2.");

        System.out.println("\n--- Verification ---");
        
        // Check if both references point to the exact same object in memory
        if (logger1 == logger2) {
            System.out.println("Success: Both logger1 and logger2 point to the SAME instance.");
            System.out.println("Logger 1 HashCode: " + logger1.hashCode());
            System.out.println("Logger 2 HashCode: " + logger2.hashCode());
        } else {
            System.out.println("Failure: Different instances were created.");
        }
    }
}