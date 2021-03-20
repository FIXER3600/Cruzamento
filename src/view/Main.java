package view;

import controller.Cruzamento;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaforo=new Semaphore(1);
        for (int idCarro=0;idCarro<4;idCarro++){
            Thread t=new Cruzamento(idCarro,semaforo);
            t.start();
        }
    }
}
