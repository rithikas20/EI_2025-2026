// Simulates a third-party or legacy logger with a different API
public class LegacyLoggerA {
    public void writeLog(String level, String message) {
        System.out.println("[LegacyA-" + level + "] " + message);
    }
}
