
package com.mycompany.trabajo_programacionserviciosprocesos;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Luismi
 */
public class ConcesionarioCompleto {
    
    private static final int numeroClientes = 9;
    

    // 4 coches disponibles (permisos)
    public static final int numeroCoches = 4;
    // crea un semáforo con un numero de permisos igual a la cantidad de coches
    // solo puede estar un cliente por coche 
    public static final Semaphore semCoches = new Semaphore(numeroCoches, true);
    
    // Cola para saber qué número de coche está libre
    public static final ConcurrentLinkedQueue<Integer> cochesDisponibles = new ConcurrentLinkedQueue<>();
    
    
    public static void main(String[] args) {
        
          // Inicializa los coches disponibles con sus números 
        for (int i = 1; i <= numeroCoches; i++) {
            cochesDisponibles.add(i);
        }

        // Crea los clientes
        for (int i = 1; i <= numeroClientes; i++) {
            
            int idConductor = i;
            
            Clientes cliente = new Clientes(idConductor);
            Thread hiloCliente = new Thread (cliente);
            hiloCliente.start();
        }
    }

    
    
}
