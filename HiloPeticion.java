package Fase1;

import ssoo.telemetría.Encargo;
import ssoo.telemetría.estación.Estación;
import ssoo.telemetría.estación.Petición;

public class HiloPeticion implements Runnable {

    private final Petición peticion;
    private final ColaTrabajos colaTrabajos;

    public HiloPeticion(Petición peticion, 
                ColaTrabajos colaTrabajos) {
        this.peticion = peticion; 
        this.colaTrabajos = colaTrabajos;   
    }
    @Override
    public void run() {
        Encargo encargo = peticion.getEncargo();
        Estación estacion = peticion.getEstación();
        //P1 Datos del encargo y estación
        System.out.println("Datos del encargo de la peticion recibida: " + encargo.getTítulo()
                +", nombre de la estación de la petición:"+ estacion.getNombre());
        //P2 Espera activa de 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //P3 Mensaje de despedida
        System.out.println("Termina hilo: "+Thread.currentThread().getName()
                         + ": Petición procesada. Adiós!");
        Trabajo trabajo = new Trabajo (peticion);
        colaTrabajos.put(trabajo);
    }
    
}
