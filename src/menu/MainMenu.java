package menu;

import java.util.Scanner;
import utils.CleanScreen;
import utils.Loading;
import utils.InnerConsoleStyle;

public class MainMenu implements InnerConsoleStyle {

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
                System.out.println(DANGER + "\nInvalid input. Please enter a number." + RESET);
                scanner.nextLine();
                continue;
            }

            handleOption(option);

        } while (option != 0);

        scanner.close();
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

    private static void handleOption(int option) throws InterruptedException {
        CleanScreen.clean();

        switch (option) {
            case 1:
                Loading.show("Loading CAIXA ECONÔMICA data", 15);
                System.out.println(INFO + "You selected CAIXA ECONÔMICA." + RESET);
                pause();
                break;

                git
            case 2:
                Loading.show("Carregando dados da CAIXA ECONÔMICA", 15);
                System.out.println(INFO + "You selected " + BOLDER + "BRADESCO." + RESET);
                pause(); // corrigido
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
                Loading.show("Terminating the application", 10);

                System.out.println(WARNING + "System closed successfully!" + RESET);
                break;

            default:
                System.out.println(BOLDER + DANGER + "\nInvalid option. Please try again." + RESET);
        }
    }

    private static void pause() {
        System.out.print(BOLDER + "\nPressione ENTER para continuar..." + RESET);
        new Scanner(System.in).nextLine();
    }
}
