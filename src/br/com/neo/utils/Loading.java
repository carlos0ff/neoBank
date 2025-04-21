package br.com.neo.utils;

/**
 * 
 */
public class Loading {

    /**
     * Exibe uma animação de loading no console.
     *
     * @param message A mensagem a ser exibida junto com o loading.
     * @param cycles Número de ciclos da animação (quanto maior, mais tempo de loading).
     * @param delay  O tempo de espera entre cada atualização da animação (em milissegundos).
     * @throws InterruptedException Caso o thread seja interrompido durante o carregamento.
     */
    public static void show(String message, int cycles, int delay) throws InterruptedException 
    {
        String[] frames = { "|", "/", "-", "\\" };
        
        for (int i = 0; i < cycles; i++) {
            System.out.print("\r" + message + " " + frames[i % frames.length]);
            Thread.sleep(delay);
        }

        System.out.print("\r" + message + " Done!      \n");
    }

    public static void main(String[] args) {
        try {
            show("Loading bank information", 30, 150);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
