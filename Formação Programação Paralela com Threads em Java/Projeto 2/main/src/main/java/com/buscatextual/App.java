package com.buscatextual;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String nome = "Jef";

        Thread threadAssinaturas1 = new Thread(new TarefaBuscaTextual("main/src/resources/assinaturas1.txt", nome));
        Thread threadAssinaturas2 = new Thread(new TarefaBuscaTextual("main/src/resources/assinaturas2.txt", nome));
        Thread threadAssinaturas3 = new Thread(new TarefaBuscaTextual("main/src/resources/autores.txt", nome));
        
        threadAssinaturas1.start();
        threadAssinaturas2.start();
        threadAssinaturas3.start();
    }
}
