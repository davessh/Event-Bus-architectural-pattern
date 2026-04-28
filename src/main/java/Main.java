import bus.EventBus;
import componentes.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        SistemaDePedidos sistemaDePedidos = new SistemaDePedidos(eventBus);

        new Barra(eventBus);
        new Cocina(eventBus);
        new PanelLED(eventBus);
        new SistemaDeSonido(eventBus);
        new com.taberna.componentes.SistemaDeHumo(eventBus);

        Banda banda = new Banda(eventBus, "Los Seguidores de Dijkstra");

        sistemaDePedidos.realizarPedido(
                "Mesa 5",
                "pedido_123",
                List.of("cerveza", "hamburguesa")
        );

        banda.tocarCancion("Through the Fire and Flames", 420);
    }
}