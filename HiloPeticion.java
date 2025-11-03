package Fase1;

import ssoo.telemetría.Encargo;
import ssoo.telemetría.estación.Estación;
import ssoo.telemetría.estación.Petición;

public class HiloPeticion implements Runnable {

    private final Petición peticion;

    public HiloPeticion(Petición peticion) {
        this.peticion = peticion; 
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
    }
    
}
