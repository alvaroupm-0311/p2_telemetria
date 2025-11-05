package Fase1;

import java.util.concurrent.ArrayBlockingQueue;

public class ColaTrabajos extends ArrayBlockingQueue<Trabajo>{

    public ColaTrabajos(int capacity) {
        super(capacity);
    }
    
}
