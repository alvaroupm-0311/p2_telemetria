package Fase1;

import java.util.ArrayList;
import java.util.List;

import ssoo.telemetría.Encargo;
import ssoo.telemetría.Informe;
import ssoo.telemetría.Telemetría;
import ssoo.telemetría.Índice;
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
        try {
            //P1 analizar el encargo y generar los trabajos
            Encargo encargo = peticion.getEncargo();
            List<Telemetría> listaTelemetrías = encargo.getTelemetrías();
            //Crear lista para guardar los trabajos generados
            List<Trabajo> listaTrabajos =  new ArrayList<Trabajo>();
            for(Telemetría telemetría : listaTelemetrías){
                Trabajo trabajo = new Trabajo (telemetría);
                //P2 encolar los trabajos generados
                colaTrabajos.put(trabajo);
                listaTrabajos.add(trabajo);
            }
            //P3 esperar a que se analicen todos los trabajos
            //y guardar las telemetrías analizadas
            List<Telemetría> listaTelemetríasAnalizadas 
                = new ArrayList<Telemetría>();
            for(Trabajo trabajo : listaTrabajos){
                listaTelemetríasAnalizadas.add(
                    trabajo.getTelemetríaAnalizada());
            }
            //P4 enviar informe
            String titulo = "informe-"+encargo.getTítulo();
            Índice índice = new Índice(listaTelemetríasAnalizadas);
            Informe informe = new Informe(titulo, índice, 
                listaTelemetríasAnalizadas);
            //P5 enviar el informe a la estación
            Estación estación = peticion.getEstación();
            estación.enviar(informe);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
