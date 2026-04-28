package componentes;

import bus.EventBus;
import eventos.BandaTocandoEvent;

public class Banda {

    private final EventBus eventBus;
    private final String nombreBanda;

    public Banda(EventBus eventBus, String nombreBanda) {
        this.eventBus = eventBus;
        this.nombreBanda = nombreBanda;
    }

    public void tocarCancion(String nombreCancion, int duracion) {
        System.out.println("[BANDA] Tocando: " + nombreCancion);
        eventBus.publicar(new BandaTocandoEvent(nombreBanda, nombreCancion, duracion));
    }
}