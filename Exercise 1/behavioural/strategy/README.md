# Strategy Pattern

Swap algorithms at runtime behind a stable interface. Here, we switch between different text formatting strategies without changing client code.

Structure
    •  TextFormatter: Interface defining format(String).
    •  UpperCaseFormatter, LowerCaseFormatter, TitleCaseFormatter: Concrete strategies implementing TextFormatter.
    •  FormatterContext: Holds the active TextFormatter and delegates format calls.
    •  StrategyDemo: Client that selects strategies and prints the results.

When to use it
- You have variants of an algorithm (sorting, formatting, pricing) and want to change behavior dynamically or based on configuration.
- You want to avoid big if/switch blocks sprinkled across the code.

How to run 
    1.Ensure you have Java installed on your machine.
    2.Compile the Java javac src/*.java Main.java files:
    3.Run StrategyDemo Class

Expected output
- Same input rendered three ways: UPPER, lower, and Title Case.

Key takeaways
- Strategies are easily testable in isolation.
- Composition over inheritance: pass behavior in instead of subclassing the context.
