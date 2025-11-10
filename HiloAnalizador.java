package Fase1;

import ssoo.telemetría.Analizador;
import ssoo.telemetría.Telemetría;

public class HiloAnalizador implements Runnable {
    private final ColaTrabajos cola;
    
    public HiloAnalizador(ColaTrabajos colaTrabajos) {
        this.cola = colaTrabajos;
    }

    @Override
    public void run() {
        try {
            Analizador analizador = new Analizador();
            while(true){
                //Desencolo el trabajo
                Trabajo trabajoEncolado = cola.take();
                //Analizo la telemetría original
                Telemetría analizada = analizador.analizar(
                    trabajoEncolado.getTelemetríaOriginal());
                //Guardo la telemetría analizada en el trabajo
                trabajoEncolado.setTelemetríaAnalizada(analizada);
            }
        } catch (InterruptedException e) {
                // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
