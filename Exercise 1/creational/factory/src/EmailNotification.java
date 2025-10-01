public class EmailNotification implements Notification {
    @Override
    public void send(String to, String message) {
        System.out.println("[Email] to=" + to + " msg=" + message);
    }
}
