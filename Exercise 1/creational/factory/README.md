# Factory Method Pattern

This project demonstrates the Factory Method design pattern in Java. The pattern defines an interface for creating an object but lets subclasses or a factory method decide which class to instantiate. In this example, a NotificationFactory creates email, SMS, or push notifications.

Structure
•  Notification: Product interface with send(to, message).
•  EmailNotification, SmsNotification, PushNotification: Concrete products.
•  NotificationFactory: Factory method (create(type)) to produce the appropriate product.
•  FactoryDemo: Client that requests products and sends messages through the common interface.

When to use it
- The client shouldn’t know which concrete class to instantiate.
- You want a single place to decide the variant (config/env/user choice).


How to run 
    1.Ensure you have Java installed on your machine.
    2.Compile the Java javac src/*.java Main.java files
    3. Run FactoryDemo class 


Expected output 
- Three lines indicating Email/SMS/Push messages were sent to their targets.

Key takeaways
- Centralizes creation logic; new variants plug in without changing callers.
- Combine with configuration to select implementations at runtime.
