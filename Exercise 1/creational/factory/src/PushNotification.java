public class PushNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[Push] to=" + to + " msg=" + message);
    }
}
