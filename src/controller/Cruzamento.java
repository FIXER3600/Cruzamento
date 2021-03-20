package controller;

import java.util.concurrent.Semaphore;

public class Cruzamento extends Thread{
    private Semaphore semaforo;
    private int sentido;


    public Cruzamento(int sentido,Semaphore semaforo) {
        this.semaforo = semaforo;
        this.sentido = sentido;
    }

    @Override
    public void run() {

        try {
            semaforo.acquire();
            cruzando();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            semaforo.release();
        }
    }

    private void cruzando() {
        switch (this.sentido){
            case 0:
                System.out.println("O carro vermelho #"+sentido+" cruza indo do norte para o sul");
                break;
            case 1:
                System.out.println("O carro Azul #"+sentido+" cruza indo do Leste para o Oeste");
                break;
            case 2:
                System.out.println("O carro Amarelo #"+sentido+" cruza indo Sul para o norte");
                break;
            case 3:
                System.out.println("O carro verde #"+sentido+" cruza indo do Oeste para o Leste");
                break;
            default:
                break;
        }
    }
}
