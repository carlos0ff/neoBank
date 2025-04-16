package br.com.neo.presentation.menu;

import java.util.Scanner;

import br.com.neo.presentation.style.InnerConsoleStyle;
import br.com.neo.utils.CleanScreen;
import br.com.neo.utils.Loading;

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

    

    

    private static void pause() {
        System.out.print(BOLDER + "\nPressione ENTER para continuar..." + RESET);
        new Scanner(System.in).nextLine();
    }
}
