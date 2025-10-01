public class Report {
    private final String header;
    private final String body;
    private final String footer;

    public Report(String header, String body, String footer) {
        this.header = header;
        this.body = body;
        this.footer = footer;
    }

    public String render() {
        StringBuilder sb = new StringBuilder();
        if (!header.isEmpty()) {
            sb.append("=== ").append(header).append(" ===\n\n");
        }
        sb.append(body).append("\n\n");
        if (!footer.isEmpty()) {
            sb.append("--- ").append(footer).append(" ---\n");
        }
        return sb.toString();
    }
}
