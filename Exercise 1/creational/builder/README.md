# Builder Pattern

This project demonstrates the Builder design pattern in Java. The pattern separates the construction of a complex object from its representation, allowing the same construction process to create different representations. In this example, a fluent builder assembles a formatted Report.

Structure
•  Report: The product with a render() method.
•  ReportBuilder: Builder interface with withHeader/withBody/withFooter and build().
•  SimpleReportBuilder: Concrete builder that stores parts and creates a Report.
•  BuilderDemo: Client that chains builder calls and prints the rendered report.

When to use it
- Objects with many optional parts or complex assembly logic.
- You want readable chainable code and to avoid “telescoping” constructors.

How to run 
    1.Ensure you have Java installed on your machine.
    2.Compile the Java javac src/*.java Main.java files:
    3. Run BuilderDemo class 


Expected output 
- A neatly formatted report with header, body bullets, and footer.

Key takeaways
- Fluent builders improve readability and testability.
- You can add alternative builders to target different output formats without changing client code.
