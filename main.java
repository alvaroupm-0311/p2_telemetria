package Fase1;

public class main {

    public static void main (String[] args) {
        System.out.println("Iniciando Receptor de Peticiones...");
        final Thread hilo = new HiloRecepcion();
        hilo.start();
    }
    
}
