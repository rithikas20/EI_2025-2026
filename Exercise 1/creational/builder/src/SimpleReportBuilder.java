public class SimpleReportBuilder implements ReportBuilder {
    private String header = "";
    private String body = "";
    private String footer = "";

    @Override
    public ReportBuilder withHeader(String header) {
        this.header = header;
        return this;
    }

    @Override
    public ReportBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public ReportBuilder withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    @Override
    public Report build() {
        return new Report(header, body, footer);
    }
}
