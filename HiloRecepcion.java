package Fase1;

import java.io.IOException;

import ssoo.telemetría.estación.Petición;
import ssoo.telemetría.estación.Receptor;

public class HiloRecepcion implements Runnable {

    public HiloRecepcion() {
        
    }

    @Override
    public void run() {
    
        try {
            Receptor receptor = new Receptor();
            while(true){
                Petición peticion = receptor.recibirPetición();
                Thread hilo = new HiloPeticion(peticion);
                hilo.start();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    
}
