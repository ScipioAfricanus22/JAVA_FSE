package exercise_1;

public class Logger {

    // Private constructor prevents instantiation from other classes
    private Logger() {
        // Optional: Protect against reflection attacks
        if (LoggerHolder.INSTANCE != null) {
            throw new IllegalStateException("Already initialized");
        }
    }

    // Static inner class responsible for holding the Singleton instance.
    // It is only loaded into memory when Logger.getInstance() is called.
    private static class LoggerHolder {
        private static final Logger INSTANCE = new Logger();
    }

    // Public static method to provide the global access point to the instance
    public static Logger getInstance() {
        return LoggerHolder.INSTANCE;
    }

    // A sample method to demonstrate the logger's functionality
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }
}