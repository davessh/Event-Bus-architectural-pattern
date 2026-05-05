# Taberna EventBus

Implementación en Java del patrón arquitectónico Publisher/Subscriber utilizando un Event Bus.

## Descripción

Este proyecto simula el sistema central de una taberna llamada "El Gólem Alquímico".

El sistema está diseñado para que los componentes no se comuniquen directamente entre sí. Toda la comunicación ocurre por medio de eventos publicados y recibidos a través del EventBus.

## Patrón implementado

Se implementa el patrón Publisher/Subscriber.

Los publicadores generan eventos y los suscriptores reaccionan a ellos sin tener referencias directas entre componentes.

## Componentes del sistema

- SistemaDePedidos: publica PedidoRealizadoEvent.
- Barra: escucha PedidoRealizadoEvent y publica BebidaServidaEvent.
- Cocina: escucha PedidoRealizadoEvent y publica ComidaPreparadaEvent.
- Banda: publica BandaTocandoEvent.
- SistemaDeSonido: escucha BandaTocandoEvent.
- PanelLED: escucha eventos de bebida, comida y banda.
- SistemaDeHumo: escucha BandaTocandoEvent y se activa solamente con una canción específica.

## Eventos implementados

- PedidoRealizadoEvent
- BebidaServidaEvent
- ComidaPreparadaEvent
- BandaTocandoEvent

Los eventos fueron implementados como clases inmutables, con atributos privados y sin métodos setters.

## Flujo del sistema

1. SistemaDePedidos publica un PedidoRealizadoEvent.
2. Barra recibe el evento y prepara una bebida en 2 segundos.
3. Cocina recibe el evento y prepara comida en 5 segundos.
4. Barra publica BebidaServidaEvent.
5. Cocina publica ComidaPreparadaEvent.
6. PanelLED muestra los mensajes correspondientes.
7. Banda publica BandaTocandoEvent.
8. SistemaDeSonido y PanelLED reaccionan al evento de la banda.
9. SistemaDeHumo se activa únicamente cuando la canción es "Through the Fire and Flames".

## Desacoplamiento

Los componentes no tienen referencias directas entre sí.

Por ejemplo:

- Barra no conoce a Cocina.
- Cocina no conoce a PanelLED.
- Banda no conoce a SistemaDeSonido.
- Banda no conoce a SistemaDeHumo.

Todos los componentes interactúan únicamente por medio del EventBus.

## Extensibilidad

Se agregó el componente SistemaDeHumo como nuevo suscriptor de BandaTocandoEvent.

Este componente se agregó sin modificar el código de Banda, EventBus ni otros componentes existentes, demostrando que el sistema puede extenderse fácilmente.

## Requisitos

- Java 17
- Maven
