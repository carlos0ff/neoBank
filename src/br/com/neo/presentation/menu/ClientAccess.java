package br.com.neo.presentation.menu;

import java.util.Scanner;

import br.com.neo.core.services.ExtractServices;
import br.com.neo.utils.*;

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

}
