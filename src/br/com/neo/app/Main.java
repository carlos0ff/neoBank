package br.com.neo.app;

import java.util.Scanner;

import br.com.banco.BankType;
import br.com.neo.services.ExtractService;
import br.com.neo.utils.CleanScreen;
import br.com.neo.utils.ConsoleStyle;
import br.com.neo.utils.Loading;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        int option;

        do {
            printMainMenu();
            option = getUserInput();

            switch (option) {
                case 1 -> handleBank(BankType.CAIXA);
                case 2 -> handleBank(BankType.BRADESCO);
                case 3 -> handleBank(BankType.ITAU);
                case 0 -> {
                    Loading.show("Encerrando o sistema", 10);
                    System.out.println(ConsoleStyle.warning("Sistema finalizado com sucesso."));
                }
                default -> System.out.println(ConsoleStyle.danger("Opção inválida. Tente novamente."));
            }
        } while (option != 0);

        scanner.close();
    }

    private static void printMainMenu() {
        CleanScreen.clean();
        System.out.println(ConsoleStyle.bold("═════════════════════════════════════════════"));
        System.out.println(ConsoleStyle.bold("         BEM-VINDO AO NEOBANK SYSTEM         "));
        System.out.println(ConsoleStyle.bold("═════════════════════════════════════════════"));
        System.out.println("[1] - Caixa Econômica");
        System.out.println("[2] - Bradesco");
        System.out.println("[3] - Itaú Unibanco");
        System.out.println("[0] - Sair");
        System.out.println(ConsoleStyle.bold("═════════════════════════════════════════════"));
        System.out.print("Escolha uma opção: ");
    }

    private static int getUserInput() {
        while (!scanner.hasNextInt()) {
            System.out.println(ConsoleStyle.danger("Entrada inválida. Digite um número."));
            scanner.nextLine();
        }
        int input = scanner.nextInt();
        scanner.nextLine(); // consumir \n
        return input;
    }

    private static void handleBank(BankType bank) throws InterruptedException {
        Loading.show("Carregando sistema do banco: " + bank.getDisplayName(), 12);
        ExtractService.extract(bank.getDisplayName());
        System.out.print(ConsoleStyle.info("\nPressione ENTER para retornar ao menu..."));
        scanner.nextLine();
    }
}
