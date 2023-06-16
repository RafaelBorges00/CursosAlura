package com.threads.banheiro;

public class FazLimpeza implements Runnable {

    private Banheiro banheiro;

    public FazLimpeza(Banheiro banheiro) {
        this.banheiro = banheiro;
    }

    @Override
    public void run() {
        while(true) {
            banheiro.limpa();
            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } 
    }

}
