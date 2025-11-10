package Fase1;

import java.util.concurrent.ArrayBlockingQueue;

import ssoo.telemetría.Numerable;

public class ColaTrabajos extends ArrayBlockingQueue<Trabajo> implements Numerable{

    public ColaTrabajos(int capacity) {
        super(capacity);
    }

    @Override
    public int numTrabajos() {
        return this.size();
    }
    
}
