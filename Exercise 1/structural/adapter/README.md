# Adapter Pattern

This project demonstrates the Adapter design pattern in Java. The pattern converts the interface of a class into another interface clients expect. In this example, two different legacy loggers are adapted to a common Logger interface so the client code stays uniform.

Structure
•  Logger: Target interface with info(String) and error(String).
•  LegacyLoggerA, LegacyLoggerB: Incompatible/legacy logging APIs (adaptees).
•  LegacyALoggerAdapter, LegacyBLoggerAdapter: Adapters that implement Logger and forward to the respective adaptee.
•  AdapterDemo: Client using Logger without knowing which legacy logger is underneath.

When to use it
- You need to integrate a library that exposes a different API from what your code expects.
- You want to standardize access to multiple similar-but-different libraries.

How to run 
    1.Ensure you have Java installed on your machine.
    2.Compile the Java javac src/*.java Main.java files:
    3.Run AdaptorDemo class


Expected output 
- Log lines with [LegacyA-*] and [LegacyB-*] prefixes produced through the unified Logger API.

Key takeaways
- Adapters isolate “weirdness” at the boundary; the rest of the app stays clean.
- Prefer composition: wrap legacy types instead of subclassing them.
