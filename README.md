# Concesionario con concurrencia en Java 

Proyecto en Java que simula un concesionario donde varios clientes prueban coches de forma concurrente,
limitando el acceso a los coches disponibles mediante sincronización.

## Descripción

El sistema dispone de un número limitado de coches.
Los clientes (hilos) deben esperar hasta que haya un coche libre para poder probarlo.
Se garantiza que cada coche solo sea usado por un cliente a la vez.

## Tecnologías

- Java
- Programación concurrente
  - `Thread`
  - `Semaphore`
  - `ConcurrentLinkedQueue`

## Funcionamiento

- Clientes: **9**
- Coches disponibles: **4**
- Máximo de clientes simultáneos: **4**

Cada cliente espera un coche, lo prueba durante un tiempo aleatorio y lo devuelve al finalizar.

## Objetivo

Práctica académica de **Programación de Servicios y Procesos** para aplicar conceptos de concurrencia y sincronización.

## Autor

Luismi
