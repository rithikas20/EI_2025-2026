public interface ReportBuilder {
    ReportBuilder withHeader(String header);
    ReportBuilder withBody(String body);
    ReportBuilder withFooter(String footer);
    Report build();
}
