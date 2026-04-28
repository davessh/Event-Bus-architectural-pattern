package componentes;

import bus.EventBus;
import eventos.BebidaServidaEvent;
import eventos.PedidoRealizadoEvent;

public class Barra {

    private final EventBus eventBus;

    public Barra(EventBus eventBus) {
        this.eventBus = eventBus;
        eventBus.suscribir(PedidoRealizadoEvent.class, this::atenderPedido);
    }

    private void atenderPedido(PedidoRealizadoEvent evento) {
        for (String item : evento.getItems()) {
            if (esBebida(item)) {
                try {
                    System.out.println("[BARRA] Preparando bebida: " + item);
                    Thread.sleep(2000);
                    eventBus.publicar(new BebidaServidaEvent(evento.getMesaId(), item));
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    private boolean esBebida(String item) {
        return item.equalsIgnoreCase("cerveza")
                || item.equalsIgnoreCase("refresco")
                || item.equalsIgnoreCase("agua");
    }
}