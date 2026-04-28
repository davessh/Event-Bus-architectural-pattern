package com.taberna.componentes;

import bus.EventBus;
import eventos.BandaTocandoEvent;

public class SistemaDeHumo {

    public SistemaDeHumo(EventBus eventBus) {
        eventBus.suscribir(BandaTocandoEvent.class, this::activarHumo);
    }

    private void activarHumo(BandaTocandoEvent evento) {
        if (evento.getNombreCancion().equalsIgnoreCase("Through the Fire and Flames")) {
            System.out.println("[HUMO] Activando efectos de humo para canción épica.");
        }
    }
}