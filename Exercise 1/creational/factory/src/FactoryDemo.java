public class FactoryDemo {
    public static void main(String[] args) {
        System.out.println("--- Creational: Factory Method (Notification) ---");
        Notification email = NotificationFactory.create("email");
        Notification sms = NotificationFactory.create("sms");
        Notification push = NotificationFactory.create("push");

        email.send("alice@example.com", "Welcome, Alice!");
        sms.send("+15551234567", "Your OTP is 123456");
        push.send("user-42", "You have a new message");
    }
}
