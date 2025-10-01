public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("--- Structural: Adapter (Logger) ---");
        Logger a = new LegacyALoggerAdapter(new LegacyLoggerA());
        Logger b = new LegacyBLoggerAdapter(new LegacyLoggerB());

        a.info("Startup complete");
        a.error("Disk space low");

        b.info("User login: bob");
        b.error("Permission denied");
    }
}
