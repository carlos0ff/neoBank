package utils;

public interface InnerConsoleStyle {
    public static final String RESET   = "\033[0m";
    public static final String SUCCESS = "\033[34m"; // Azul
    public static final String INFO    = "\033[32m"; // Verde
    public static final String WARNING = "\033[31m"; // Vermelho
    public static final String DANGER  = "\033[33m"; // Amarelo
    public static final String BOLDER  = "\033[1m";  // Negrito

    public static String success(String message) {
        return SUCCESS + message + RESET;
    }

    public static String info(String message) {
        return INFO + message + RESET;
    }

    public static String warning(String message) {
        return WARNING + message + RESET;
    }

    public static String danger(String message) {
        return DANGER + message + RESET;
    }

    public static String bold(String message) {
        return BOLDER + message + RESET;
    }
}
