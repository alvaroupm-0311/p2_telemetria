package Fase1;

public class main {
    public static void main(String[] args) {
        System.out.println("Iniciando receptor de peticiones...");
        final Thread hilo = new Thread(new HiloRecepcion());
        hilo.start();
    }
}
