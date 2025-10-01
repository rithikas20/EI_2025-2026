public class TimingDecorator extends ServiceDecorator {
    public TimingDecorator(Service inner) {
        super(inner);
    }

    @Override
    public String execute() throws Exception {
        long start = System.nanoTime();
        try {
            return inner.execute();
        } finally {
            long end = System.nanoTime();
            System.out.println("TimingDecorator: took " + ((end - start) / 1_000_000.0) + " ms");
        }
    }
}
