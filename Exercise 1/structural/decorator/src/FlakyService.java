public class FlakyService implements Service {
    private int failuresRemaining;

    public FlakyService(int failures) {
        this.failuresRemaining = failures;
    }

    @Override
    public String execute() throws Exception {
        if (failuresRemaining > 0) {
            failuresRemaining--;
            throw new Exception("Transient failure, tries left before success: " + failuresRemaining);
        }
        return "FlakyService: success";
    }
}
