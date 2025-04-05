package main;

import java.util.Scanner;
import utils.CleanScreen;


public class MainMenu {

    public static final String RESET   = "\033[0m";
    public static final String SUCCESS = "\033[34m"; // Azul
    public static final String INFO    = "\033[32m"; // Verde
    public static final String WARNING = "\033[31m"; // Vermelho
    public static final String DANGER  = "\033[33m"; // Amarelo
    public static final String BOLDER  = "\033[1m";  // Negrito

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            CleanScreen.clean(); 

            if (hasNextInt) {
                
            }

            handleOption(choice);

        } while (choice != 0);

        scanner.close();
    }

    private static void printMenu(){
        
    }

    private static void handleOption(int choice) throws InterruptedException 
    {
        switch (choice) {
            case 1:
                System.out.println("\nYour Selected  " + BOLDER + INFO + "CAIXA" + RESET);
                Thread.sleep(2000); 
                break;

            case 0:
                System.out.println(WARNING + "Saindo do programa..." + RESET);
                Thread.sleep(1000);
                break;

            default:
                System.out.println(DANGER + "Opção inválida!" + RESET);
                Thread.sleep(1500);
                break;
        }
    }
}
