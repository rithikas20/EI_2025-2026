public class DecoratorDemo {
    public static void main(String[] args) {
        System.out.println("--- Structural: Decorator (Timing + Retry) ---");
        Service base = new FlakyService(2); // fail first 2 times, then succeed
        Service withRetry = new RetryDecorator(base, 3);
        Service withTimingAndRetry = new TimingDecorator(withRetry);
        try {
            String result = withTimingAndRetry.execute();
            System.out.println("Result: " + result);
        } catch (Exception e) {
            System.out.println("Final failure: " + e.getMessage());
        }
    }
}
