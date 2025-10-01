public abstract class ServiceDecorator implements Service {
    protected final Service inner;

    protected ServiceDecorator(Service inner) {
        this.inner = inner;
    }
}
