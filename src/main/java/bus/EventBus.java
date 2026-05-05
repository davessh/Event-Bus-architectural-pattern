package bus;

import java.util.*;

public class EventBus {

    private final Map<Class<?>, List<Suscriptor<?>>> suscriptores = new HashMap<>();

    public <T> void suscribir(Class<T> tipoEvento, Suscriptor<T> suscriptor) {
        suscriptores
                .computeIfAbsent(tipoEvento, k -> new ArrayList<>())
                .add(suscriptor);
    }

    public <T> void desuscribir(Class<T> tipoEvento, Suscriptor<T> suscriptor) {
        List<Suscriptor<?>> lista = suscriptores.get(tipoEvento);

        if (lista != null) {
            lista.remove(suscriptor);
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void publicar(T evento) {
        Class<?> tipoEvento = evento.getClass();
        List<Suscriptor<?>> lista = suscriptores.getOrDefault(tipoEvento, Collections.emptyList());

        for (Suscriptor<?> suscriptor : new ArrayList<>(lista)) {
            ((Suscriptor<T>) suscriptor).manejar(evento);
        }
    }
}