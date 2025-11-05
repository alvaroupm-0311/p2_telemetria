package Fase1;

public class main {

    public static void main (String[] args) {
        System.out.println("Iniciando Receptor de Peticiones...");
        final ColaTrabajos cola = new ColaTrabajos (10);
        final Thread hilo = new HiloRecepcion(cola);
        hilo.start();
    }
    
}
