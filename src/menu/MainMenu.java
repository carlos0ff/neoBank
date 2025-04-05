package menu;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import utils.CleanScreen;
import utils.ConsoleStyle;


public class MainMenu implements ConsoleStyle
{

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int option = -1; 

        do {
            printMenu();
            System.out.print("Your choice: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println(DANGER + "\nInvalid input. Please enter a number.");
                scanner.nextLine(); 
                continue;
            }

            handleOption(option);

        } while (option != 0);
    }

    private static void printMenu() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("         NEO BANK  - INTERNET BANKING        ");
        System.out.println("═════════════════════════════════════════════");
        System.out.println("   [ 1 ] CAIXA ECONÔMICA");
        System.out.println("   [ 2 ] BRADESCO");
        System.out.println("   [ 3 ] ITAÚ UNIBANCO");
        System.out.println("   [ 4 ] BANCO DO BRASIL");
        System.out.println("   [ 0 ] Exit");
        System.out.println("═══════════════════════════════════════════");
    }

    private static void handleOption(int option) throws InterruptedException 
    {
        CleanScreen.clean();

        switch (option) {
            case 1:
                System.out.println(INFO + "You selected CAIXA ECONÔMICA." + RESET);
                pause();
                break;

            case 2:
                System.out.println(INFO + "You selected" + BOLDER + " BRADESCO." + RESET);
                printMenu(scanner);
                break;

            case 3:
                System.out.println(INFO + "You selected " + BOLDER + "ITAÚ UNIBANCO." + RESET);
                pause();
                break;

            case 4:
                System.out.println(INFO + "You selected " + BOLDER + "BANCO DO BRASIL." + RESET);
                pause();
                break;

            case 0:
                System.out.println(WARNING + "Exiting system..." + RESET);
                break;

            default:
                System.out.println(BOLDER + DANGER + "\nInvalid option. Please try again." + RESET);
        }
    }
}
