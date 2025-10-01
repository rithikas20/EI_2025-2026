public class ObserverDemo {
    public static void main(String[] args) {
        System.out.println("--- Behavioral: Observer (Event Bus) ---");
        EventBus bus = new EventBus();

        EventListener emailListener = (event, payload) ->
                System.out.println("EmailService received '" + event + "' with payload: " + payload);
        EventListener analyticsListener = (event, payload) ->
                System.out.println("AnalyticsService tracked '" + event + "' with payload: " + payload);

        bus.subscribe("order_created", emailListener);
        bus.subscribe("order_created", analyticsListener);

        bus.emit("order_created", "orderId=1234");

        bus.unsubscribe("order_created", emailListener);
        bus.emit("order_created", "orderId=5678");
    }
}
