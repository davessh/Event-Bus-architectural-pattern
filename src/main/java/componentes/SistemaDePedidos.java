package componentes;

import bus.EventBus;
import eventos.PedidoRealizadoEvent;

import java.util.List;

public class SistemaDePedidos {

    private final EventBus eventBus;

    public SistemaDePedidos(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    public void realizarPedido(String mesaId, String pedidoId, List<String> items) {
        System.out.println("[PEDIDOS] Pedido recibido en " + mesaId + ": " + items);
        eventBus.publicar(new PedidoRealizadoEvent(mesaId, pedidoId, items));
    }
}