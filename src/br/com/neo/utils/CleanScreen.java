package br.com.neo.utils;


/**
 * Classe utilitária para limpar o console/terminal.
 */
public class CleanScreen {

    /**
     * Limpa o console de acordo com o sistema operacional.
     */
    public static void clean() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
            
        } catch (Exception e) {
            System.out.println("Unable to clear screen:" + e.getMessage());
        }
    }
}
