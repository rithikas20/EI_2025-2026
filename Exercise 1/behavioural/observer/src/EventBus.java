import java.util.*;

public class EventBus {
    private final Map<String, List<EventListener>> listeners = new HashMap<>();

    public void subscribe(String eventName, EventListener listener) {
        listeners.computeIfAbsent(eventName, k -> new ArrayList<>()).add(listener);
    }

    public void unsubscribe(String eventName, EventListener listener) {
        List<EventListener> list = listeners.get(eventName);
        if (list != null) {
            list.remove(listener);
            if (list.isEmpty()) {
                listeners.remove(eventName);
            }
        }
    }

    public void emit(String eventName, Object payload) {
        List<EventListener> list = listeners.get(eventName);
        if (list != null) {
            for (EventListener l : new ArrayList<>(list)) {
                l.onEvent(eventName, payload);
            }
        }
    }
}
