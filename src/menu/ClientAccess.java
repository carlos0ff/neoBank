package menu;

import java.util.Scanner;

import services.ExtractServices;
import utils.*;

public class ClientAccess implements ConsoleStyle
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        do {
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

    private static void printMenu(String bankName) throws InterruptedException 
    {
        System.out.println("\n═════════════════════════════════════════════");
        System.out.println("        :: " + bankName.toUpperCase() + " SYSTEM MENU ::");
        System.out.println("═════════════════════════════════════════════");
        System.out.println("[ 1 ] - System Administration");
        System.out.println("[ 2 ] - Client Access");
        System.out.println("[ 3 ] - Open a New Account");
        System.out.println("[ 4 ] - Help & Support");
        System.out.println("[ 5 ] - Exit to Main Menu");
        System.out.println("[ 6 ] - View Statement");
        System.out.println("═════════════════════════════════════════════");
        System.out.print("Enter your choice: ");
    }

    private static void handleOption(int option) throws InterruptedException 
    {

        switch (option) {
            case 1:
                System.out.println("Administration panel loading...");
                Thread.sleep(1000);
                break;
            case 2:
                System.out.println("Redirecting to client access...");
                Thread.sleep(1000);
                break;
            case 3:
                System.out.println("Opening account creation...");
                Thread.sleep(1000);
                break;
            case 4:
                System.out.println("Support menu coming soon...");
                Thread.sleep(1000);
                break;
            case 5:
                System.out.println("Returning to main menu...");
                Thread.sleep(1000);
                break;
            case 6:
                ExtractServices.extract();
                System.out.println("\nPress ENTER to return...");
                scanner.nextLine();
                break;
            default:
                System.out.println(DANGER + "Invalid option. Try again." + RESET);
                Thread.sleep(1000);
        }
    }
}
