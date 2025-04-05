package utils;


public class CleanScreen {

    public static void clean() {
        System.out.print("\33[H\033[2J");
        System.out.flush();
    }
}
