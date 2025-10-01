// Another third-party logger with yet another API
public class LegacyLoggerB {
    public void print(String priority, String message) {
        System.out.println("[LegacyB-" + priority + "] " + message);
    }
}
