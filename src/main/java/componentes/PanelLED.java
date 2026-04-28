package componentes;

import bus.EventBus;
import eventos.BandaTocandoEvent;
import eventos.BebidaServidaEvent;
import eventos.ComidaPreparadaEvent;

public class PanelLED {

    public PanelLED(EventBus eventBus) {
        eventBus.suscribir(BebidaServidaEvent.class, this::mostrarBebida);
        eventBus.suscribir(ComidaPreparadaEvent.class, this::mostrarComida);
        eventBus.suscribir(BandaTocandoEvent.class, this::mostrarBanda);
    }

    private void mostrarBebida(BebidaServidaEvent evento) {
        System.out.println("[PANEL LED] Bebida servida en " + evento.getMesaId() + ": " + evento.getBebida());
    }

    private void mostrarComida(ComidaPreparadaEvent evento) {
        System.out.println("[PANEL LED] Comida preparada para pedido "
                + evento.getPedidoId() + ": " + evento.getPlato());
    }

    private void mostrarBanda(BandaTocandoEvent evento) {
        System.out.println("[PANEL LED] Ahora toca "
                + evento.getNombreBanda() + ": " + evento.getNombreCancion());
    }
}