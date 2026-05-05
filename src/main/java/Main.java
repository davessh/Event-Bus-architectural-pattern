import bus.EventBus;
import bus.Suscriptor;
import componentes.*;
import eventos.BandaTocandoEvent;


import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        EventBus eventBus = new EventBus();

        SistemaDePedidos sistemaDePedidos = new SistemaDePedidos(eventBus);

        new Barra(eventBus);
        new Cocina(eventBus);
        new PanelLED(eventBus);
        new SistemaDeSonido(eventBus);
        new SistemaDeHumo(eventBus);

        Banda banda = new Banda(eventBus, "Los Seguidores de Dijkstra");

        System.out.println("=== INICIO DEL SISTEMA EVENT BUS ===");

        sistemaDePedidos.realizarPedido(
                "Mesa 5",
                "pedido_123",
                List.of("cerveza", "hamburguesa")
        );

        Thread.sleep(1000);

        banda.tocarCancion("El Algoritmo del Amor", 180);

        Thread.sleep(1000);

        banda.tocarCancion("Through the Fire and Flames", 420);

        System.out.println("\n=== DEMOSTRACIÓN DE DESUSCRIBIR ===");

        Suscriptor<BandaTocandoEvent> suscriptorTemporal = evento ->
                System.out.println("[TEMPORAL] Escuché la canción: " + evento.getNombreCancion());

        eventBus.suscribir(BandaTocandoEvent.class, suscriptorTemporal);

        banda.tocarCancion("Prueba con suscriptor temporal", 120);

        eventBus.desuscribir(BandaTocandoEvent.class, suscriptorTemporal);

        banda.tocarCancion("Prueba después de desuscribir", 120);

        Thread.sleep(7000);

        System.out.println("=== FIN DEL SISTEMA ===");
    }
}