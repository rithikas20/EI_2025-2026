# Decorator Pattern

This project demonstrates the Decorator design pattern in Java. The pattern attaches additional responsibilities to an object dynamically, offering a flexible alternative to subclassing. In this example, a Service is wrapped with retry and timing decorators.
Add behavior to an object without changing its class. Here we wrap a Service with decorators that add retry logic and timing measurements.

Structure
•  Service: Component interface defining execute().
•  FlakyService: Concrete component that fails a few times before succeeding.
•  ServiceDecorator: Base decorator that holds an inner Service.
•  RetryDecorator, TimingDecorator: Concrete decorators that add retry and timing behavior.
•  DecoratorDemo: Client that composes decorators around the service and runs it.

When to use it
- Add cross‑cutting behavior (caching, logging, retries, metrics) to specific instances, not all instances of a class.
- Stack multiple behaviors flexibly at runtime.

How to run 
    1.Ensure you have Java installed on your machine.
    2.Compile the Java javac src/*.java Main.java files:
    3.Run DecoratorDemo class

Expected output (abridged)
- One or more retry messages followed by timing and a final success line.

Key takeaways
- Open for extension, closed for modification: add behavior by composition.
- Keep decorators small and single‑purpose; compose as needed.
