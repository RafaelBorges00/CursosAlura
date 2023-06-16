package com.threads.banheiro;

public class App 
{
    public static void main( String[] args )
    {
        Banheiro banheiro = new Banheiro();

        Thread convidado1 = new Thread(new FazNumero1(banheiro), "João");
        Thread convidado2 = new Thread(new FazNumero1(banheiro), "Pedro");
        Thread convidado3 = new Thread(new FazNumero2(banheiro), "Maria");
        Thread convidado4 = new Thread(new FazNumero2(banheiro), "Ana");
        Thread limpeza = new Thread(new FazLimpeza(banheiro), "Limpeza");
        limpeza.setDaemon(true);

        convidado1.start();
        convidado2.start();
        convidado3.start();
        convidado4.start();
        limpeza.start();
    }
}
