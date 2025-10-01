public class LegacyBLoggerAdapter implements Logger {
    private final LegacyLoggerB adaptee;

    public LegacyBLoggerAdapter(LegacyLoggerB adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void info(String message) {
        adaptee.print("INFO", message);
    }

    @Override
    public void error(String message) {
        adaptee.print("ERROR", message);
    }
}
