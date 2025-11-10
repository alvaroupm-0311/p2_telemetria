package Fase1;

import ssoo.telemetría.Telemetría;

public class Trabajo {

    private final Telemetría telemetriaOriginal;
    private Telemetría telemetriaAnalizada;

    public Trabajo(Telemetría telemetriaOriginal) {
        this.telemetriaOriginal = telemetriaOriginal;
        this.telemetriaAnalizada = null;
    }
    // Obtengo telemetría original para el hilo Analizador
    public Telemetría getTelemetríaOriginal() {
        return telemetriaOriginal;
    }
    // Obtengo telemetría analizada para el hilo Petición
    public synchronized Telemetría getTelemetríaAnalizada() throws InterruptedException {
        while(telemetriaAnalizada == null){
            wait();
        }
        return telemetriaAnalizada;
    }
    // Introduzco telemetría analizada por el analizador para el hilo Peticion
    public synchronized void setTelemetríaAnalizada(Telemetría telemetria) {
        this.telemetriaAnalizada = telemetria;
        notifyAll();
    }
    
}
