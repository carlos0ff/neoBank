package br.com.neo.core.services;

import java.util.Scanner;

import br.com.neo.utils.CleanScreen;

public class LoanMenuService {

    private static final String DANGER = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    /**
     * Exibe o menu de empréstimos com opções disponíveis.
     * @param scanner Scanner para entrada do usuário
     */
    public void showLoanMenu(Scanner scanner) {
        int option = -1;
        final int lineLength = 45;

        do {
            CleanScreen.clean();

            String title = "LOAN SERVICES MENU";
            int padding = (lineLength - title.length()) / 2;
            String centeredTitle = " ".repeat(Math.max(padding, 0)) + title;

            System.out.println("\n" + "═".repeat(lineLength));
            System.out.println("\u001B[34m" + centeredTitle + "\u001B[0m");
            System.out.println("═".repeat(lineLength));

            System.out.println("[ 1 ] - Simulate Personal Loan");
            System.out.println("[ 2 ] - Request Loan");
            System.out.println("[ 3 ] - View Loan Conditions");
            System.out.println("[ 0 ] - Return to Bank Menu");
            System.out.println("═".repeat(lineLength));
            System.out.print("Select an option: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine();
            } else {
                System.out.println(DANGER + "\nInvalid input. Please enter a number." + RESET);
                scanner.nextLine();
                continue;
            }

            switch (option) {
                case 1:
                    simulateLoan(scanner);
                    break;
                case 2:
                    requestLoan(scanner);
                    break;
                case 3:
                    showLoanConditions();
                    break;
                case 0:
                    System.out.println("Returning to previous menu...");
                    break;
                default:
                    System.out.println(DANGER + "\nInvalid option. Please try again." + RESET);
            }

            if (option != 0) {
                System.out.print("\nPress Enter to continue...");
                scanner.nextLine();
            }

        } while (option != 0);
    }

    /**
     * 
     * @param scanner
     */
    private void simulateLoan(Scanner scanner) {
        System.out.println("\n--- Loan Simulation ---");
        System.out.print("Enter the amount: R$ ");
        double amount = scanner.nextDouble();

        System.out.print("Enter the term (months): ");
        int months = scanner.nextInt();
        scanner.nextLine();

        double interestRate = 0.02;

        double total = amount * Math.pow((1 + interestRate), months);
        double monthly = total / months;

        System.out.printf("Monthly payment: R$ %.2f\n", monthly);
        System.out.printf("Total to pay: R$ %.2f\n", total);
    }

    private void requestLoan(Scanner scanner) {
        System.out.println("\n--- Loan Request ---");
        System.out.print("Enter your CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Requested amount: R$ ");
        double amount = scanner.nextDouble();

        System.out.print("Term (months): ");
        int months = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Your loan request has been submitted.");
        System.out.printf("CPF: %s | Amount: R$ %.2f | Term: %d months\n", cpf, amount, months);
    }

    private void showLoanConditions() {
        System.out.println("\n--- Loan Conditions ---");
        System.out.println("• Interest rate: 2% per month");
        System.out.println("• Minimum amount: R$ 500");
        System.out.println("• Maximum term: 48 months");
        System.out.println("• Subject to credit approval");
    }
}
