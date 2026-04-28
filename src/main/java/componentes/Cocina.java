package componentes;

import bus.EventBus;
import eventos.ComidaPreparadaEvent;
import eventos.PedidoRealizadoEvent;

public class Cocina {

    private final EventBus eventBus;

    public Cocina(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.suscribir(PedidoRealizadoEvent.class, this::prepararComida);
    }

    private void prepararComida(PedidoRealizadoEvent evento) {
        for (String item : evento.getItems()) {
            if (esComida(item)) {
                try {
                    System.out.println("[COCINA] Preparando comida: " + item);
                    Thread.sleep(5000);
                    eventBus.publicar(new ComidaPreparadaEvent(evento.getPedidoId(), item));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private boolean esComida(String item) {
        return item.equalsIgnoreCase("hamburguesa")
                || item.equalsIgnoreCase("pizza")
                || item.equalsIgnoreCase("tacos");
    }
}