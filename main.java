package Fase1;

import ssoo.telemetría.panel.PanelVisualizador;

public class main {

    public static void main (String[] args) {
        System.out.println("Iniciando Receptor de Peticiones...");
        final ColaTrabajos cola = new ColaTrabajos (10);
        PanelVisualizador.getPanel().registrarColaTrabajos(cola);
        final Thread hilo = new HiloRecepcion(cola);
        hilo.start();
        int maxHilos = Runtime.getRuntime().availableProcessors();
        // int maxHilos = 8; // Descomentar para pruebas con 8 hilos    
        for (int i = 0; i < maxHilos; i++) {
            Thread hiloA = new Thread(new HiloAnalizador(cola));
            hiloA.setName("Hilo Analizador "+i);
            hiloA.start();
        }
    }
    
}
