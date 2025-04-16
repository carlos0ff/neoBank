package br.com.neo.utils;

public class Loading {

    public static void show(String message, int cycles) throws InterruptedException 
    {
        String[] frames = { "|", "/", "-", "\\" };

        for (int i = 0; i < cycles; i++) {
            System.out.print("\r" + message + " " + frames[i % frames.length]);
            Thread.sleep(150);
        }

        System.out.print("\r" + message + " Done!      \n");
    }
}
