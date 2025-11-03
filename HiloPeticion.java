package Fase1;

import ssoo.telemetría.Encargo;
import ssoo.telemetría.estación.Estación;
import ssoo.telemetría.estación.Petición;

public class HiloPeticion extends Thread{

    private Petición peticion;

    public HiloPeticion(Petición peticion){
        this.peticion = peticion;
    }
    @Override
    public void run(){
        //P1 Mostrar datos del encargo y de la estacion
        Encargo encargo = peticion.getEncargo();
        Estación estacion = peticion.getEstación();
        System.out.println("El titulo del encargo es:"+ encargo.getTítulo() +
        ", la estacion se llama "+ estacion.getNombre());
        
        //P2 espera de 5 segundos
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //P3 Mostrar mensaje de despedida
        System.out.println("El hilo:"+Thread.currentThread().getName()+" ha terminado, adios!");
    }
}
