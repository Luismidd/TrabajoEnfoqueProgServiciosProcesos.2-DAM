package com.mycompany.trabajo_programacionserviciosprocesos;

/**
 *
 * @author Luismi
 */
public class Clientes implements Runnable {

    private final int idCliente;

    public Clientes(int idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        
        Integer idCoche = null;
        
        
        //según el el id del cliente se obtiene un nombre
        String nombreCliente = EnumClientes.getNombrePorId(idCliente);  
        
        
        try {
            System.out.println("Cliente " + nombreCliente 
                    + " esperando un coche...");

            // Espera hasta que haya coche disponible
            ConcesionarioCompleto.semCoches.acquire();

            // Coge un coche libre (quita un coche de la cola de coches disponibles)
            idCoche = ConcesionarioCompleto.cochesDisponibles.poll();
            
            if (idCoche == null) {
                System.out.println("ERROR: no hay coches disponibles aunque el semaforo lo permite");
                return;
            }

            System.out.println(">>> Cliente " + nombreCliente
                    + " empieza a probar el coche " + idCoche);

            // Simula prueba del coche
            // Se le da un tiempo al azar 
            // se entiende que todos los clientes no tardan lo mismo en hacer la prueba
            int tiempo = (int) (Math.random() * 4000) + 1000; // 1000 a 5000 ms
            Thread.sleep(tiempo);
            

            System.out.println("<<< Cliente " + nombreCliente 
                    + " terminó de probar el coche " + idCoche + " despues de " + tiempo + "ms");

           

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        
        
        }finally{
            // Devuelve el coche y libera el semáforo
            if (idCoche != null) {
                //añade el coche a la cola de coches disponibles
                ConcesionarioCompleto.cochesDisponibles.add(idCoche);
            }
            //libera el semáforo
            ConcesionarioCompleto.semCoches.release();
                     
        }
    }

}
