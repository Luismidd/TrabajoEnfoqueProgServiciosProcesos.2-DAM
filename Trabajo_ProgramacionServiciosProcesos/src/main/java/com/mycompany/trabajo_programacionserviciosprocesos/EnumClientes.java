

package com.mycompany.trabajo_programacionserviciosprocesos;

/**
 *
 * @author Luismi
 */
public enum EnumClientes {
    
    CLIENTE1 (1, "Manuel"),
    CLIENTE2 (2, "Pepe"),
    CLIENTE3 (3, "Antonio"),
    CLIENTE4 (4, "Juan"),
    CLIENTE5 (5, "Javier"),
    CLIENTE6 (6, "Ana"),
    CLIENTE7 (7, "Maria"),
    CLIENTE8 (8, "Julia"),
    CLIENTE9 (9, "Alejandra");
    
    
    
    private final int id;
    private final String nombre;
    
    

    EnumClientes(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    // Método para obtener el nombre según el número de cliente
    public static String getNombrePorId(int idCliente) {
        for (EnumClientes c : values()) {
            if (c.getId() == idCliente) {
                return c.getNombre();
            }
        }
        //valor por defecto si no está definido ese número de cliente
        return "Cliente " + idCliente; // fallback
    }
    
    
    
}
