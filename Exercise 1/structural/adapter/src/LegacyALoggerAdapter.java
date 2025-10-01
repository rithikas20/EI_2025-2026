public class LegacyALoggerAdapter implements Logger {
    private final LegacyLoggerA adaptee;

    public LegacyALoggerAdapter(LegacyLoggerA adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void info(String message) {
        adaptee.writeLog("INFO", message);
    }

    @Override
    public void error(String message) {
        adaptee.writeLog("ERROR", message);
    }
}
