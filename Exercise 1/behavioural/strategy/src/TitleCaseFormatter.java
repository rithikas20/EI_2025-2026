import java.util.Arrays;
import java.util.stream.Collectors;

public class TitleCaseFormatter implements TextFormatter {
    @Override
    public String format(String input) {
        return Arrays.stream(input.split("\\s+"))
                .map(s -> s.isEmpty() ? s : Character.toUpperCase(s.charAt(0)) + s.substring(1).toLowerCase())
                .collect(Collectors.joining(" "));
    }
}
