package com.threads.banheiro;

public class Banheiro {

    private boolean ehSujo = true;

    public void fazNumero1() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Batendo na porta do banheiro1");
        synchronized (this) {
            if(ehSujo) {
                esperaLaFora(nome);
            }
            System.out.println(nome + " Entrando no banheiro1");
            System.out.println(nome + " Usando banheiro nro1");
            dormeUmPouco(5000);
            this.ehSujo = true;
            System.out.println(nome + " Saindo do banheiro1");
        }
    }

    private void dormeUmPouco(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void fazNumero2() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Batendo na porta do banheiro2");
        synchronized (this) {
            while (ehSujo) {
                esperaLaFora(nome);
            }

            System.out.println(nome + " Entrando no banheiro2");
            System.out.println(nome + " Usando banheiro nro2");

            dormeUmPouco(10000);
            
            System.out.println(nome + " Saindo do banheiro2");
        }
    }

    private void esperaLaFora(String nome) {
        System.out.println(nome + ", eca, o banheiro está sujo !");
        try {
            this.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    protected void limpa() {
        String nome = Thread.currentThread().getName();

        System.out.println(nome + " Batendo na porta do banheiro1");
        synchronized(this) {
            System.out.println(nome + " limpando o banheiro");
            this.ehSujo = false;
            try {
                Thread.sleep(13000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.notifyAll();
            System.out.println(nome + " saindo do banheiro");
        }
    }
}
