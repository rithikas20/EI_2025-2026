public class StrategyDemo {
    public static void main(String[] args) {
        System.out.println("--- Behavioral: Strategy (Text Formatter) ---");
        FormatterContext ctx = new FormatterContext(new UpperCaseFormatter());
        String text = "hello world from strategy";
        System.out.println("Upper:   " + ctx.format(text));

        ctx.setStrategy(new LowerCaseFormatter());
        System.out.println("Lower:   " + ctx.format(text));

        ctx.setStrategy(new TitleCaseFormatter());
        System.out.println("Title:   " + ctx.format(text));
    }
}
