package bus;

@FunctionalInterface
public interface Suscriptor<T> {
    void manejar(T evento);
}
