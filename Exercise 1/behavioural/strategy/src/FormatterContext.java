public class FormatterContext {
    private TextFormatter strategy;

    public FormatterContext(TextFormatter strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(TextFormatter strategy) {
        this.strategy = strategy;
    }

    public String format(String input) {
        return strategy.format(input);
    }
}
