package br.com.neo.presentation.style;


import java.util.Scanner;

import br.com.neo.utils.CleanScreen;
import br.com.neo.utils.Loading;

/**
 * Interface funcional para representar um sistema bancário de múltiplos bancos.
 * Fornece métodos utilitários para menus, estilo ANSI no console e controle de navegação entre menus.
 * Pode ser usada diretamente como um utilitário estático.
 */
public interface StyledText {

    /** Estilos ANSI para colorir e formatar o texto no terminal **/
    String RESET   = "\033[0m";
    String SUCCESS = "\033[34m";
    String INFO    = "\033[32m"; 
    String WARNING = "\033[31m"; 
    String DANGER  = "\033[33m"; 
    String BOLDER  = "\033[1m";  

    /**
     * Retorna uma mensagem estilizada com a cor de sucesso (azul).
     * @param message Texto a ser estilizado
     * @return String formatada com cor de sucesso
     */
    public static String success(String message) {
        return SUCCESS + message + RESET;
    }

    /**
     * Retorna uma mensagem estilizada com a cor de informação (verde).
     * @param message Texto a ser estilizado
     * @return String formatada com cor de informação
     */
    public static String info(String message) {
        return INFO + message + RESET;
    }

    /**
     * Retorna uma mensagem estilizada com a cor de aviso (vermelho).
     * @param message Texto a ser estilizado
     * @return String formatada com cor de aviso
     */
    public static String warning(String message) {
        return WARNING + message + RESET;
    }

    /**
     * Retorna uma mensagem estilizada com a cor de perigo (amarelo).
     * @param message Texto a ser estilizado
     * @return String formatada com cor de perigo
     */
    public static String danger(String message) {
        return DANGER + message + RESET;
    }

    /**
     * Retorna uma mensagem com estilo em negrito.
     * @param message Texto a ser estilizado
     * @return String formatada em negrito
     */
    public static String bolder(String message) {
        return BOLDER + message + RESET;
    }
}
