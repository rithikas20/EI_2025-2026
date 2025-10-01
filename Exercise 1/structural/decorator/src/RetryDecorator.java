public class RetryDecorator extends ServiceDecorator {
    private final int maxRetries;

    public RetryDecorator(Service inner, int maxRetries) {
        super(inner);
        this.maxRetries = Math.max(0, maxRetries);
    }

    @Override
    public String execute() throws Exception {
        int attempt = 0;
        while (true) {
            try {
                return inner.execute();
            } catch (Exception e) {
                if (attempt >= maxRetries) {
                    throw e;
                }
                attempt++;
                System.out.println("RetryDecorator: retrying (attempt " + attempt + "/" + maxRetries + ") due to: " + e.getMessage());
            }
        }
    }
}
