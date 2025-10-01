# Observer Pattern

This project demonstrates the Observer design pattern in Java. The pattern defines a one‑to‑many dependency so when one object changes state, all of its dependents are notified automatically. In this example, an EventBus publishes named events and multiple listeners react to them.

A simple publish/subscribe system where many listeners can react to the same event without the event source knowing who they are. This decouples “who produces data” from “who consumes it.”

Structure
•  EventListener: Functional interface with onEvent(eventName, payload).
•  EventBus: Publisher that manages subscribers by event name and emits notifications.
•  ObserverDemo: Client that subscribes/unsubscribes listeners and emits events.

When to use it
- Multiple parts of your app need to react to something (user actions, domain events, background jobs) without tight coupling.
- You want to add/remove reactions at runtime.

How to run 
    1.Ensure you have Java installed on your machine.
    2.Compile the Java javac src/*.java Main.java files:
    3.Run ObseverDemo class

Expected output 
- Both listeners react to the first emit.
- After unsubscribe, only AnalyticsService reacts to the second emit.

Key takeaways
- Loose coupling: publishers don’t know about concrete subscribers.
- Easy extensibility: add a new subscriber without changing the publisher.
- Be mindful of memory leaks: always provide a way to unsubscribe.
