public class SmsNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[SMS] to=" + to + " msg=" + message);
    }
}
