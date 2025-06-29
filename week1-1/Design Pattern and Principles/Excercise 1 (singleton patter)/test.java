public class test {
    public static void main(String[] args) {
        // Getting logger instances
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        // Logging messages
        logger1.log("This is the first log message.");
        logger2.log("This is the second log message.");

        // Checking if both loggers are the same
        if (logger1 == logger2) {
            System.out.println("Both logger instances are the same (Singleton works).");
        } else {
            System.out.println("Logger instances are different (Singleton failed).");
        }
    }
}
