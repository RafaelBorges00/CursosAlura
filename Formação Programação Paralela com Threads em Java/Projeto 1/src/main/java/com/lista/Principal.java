package com.lista;

public class Principal {

    public static void main(String[] args) throws InterruptedException {

        Lista lista = new Lista();
        //List<String> lista = new Vector<String>(); Faz a mesma coisa da linha acima

        for(int i = 0; i < 10; i++) {
            new Thread(new TarefaAdicionarElemento(lista, i)).start();
        }

        new Thread(new TarefaImprimir(lista)).start();

        Thread.sleep(2000);

       
    }
}
