package com.threads;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        /* Threads em classes anônimas */
       new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("resposta");
            }
        }).start();
    }
}
