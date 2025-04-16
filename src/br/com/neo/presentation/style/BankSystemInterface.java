package utils;

import java.util.Scanner;
import br.com.neo.core.*;
import br.com.neo.core.services.ExtractServices;
import br.com.neo.utils.CleanScreen;
import br.com.neo.utils.Loading;

/**
 * Interface funcional para representar um sistema bancário de múltiplos bancos.
 * Fornece métodos utilitários para menus, estilo ANSI no console e controle de navegação entre menus.
 * Pode ser usada diretamente como um utilitário estático.
 */
public interface BankSystemInterface {

    // Estilos ANSI para colorir e formatar o texto no terminal
    String RESET   = "\033[0m";
    String SUCCESS = "\033[34m"; // Azul
    String INFO    = "\033[32m"; // Verde
    String WARNING = "\033[31m"; // Vermelho
    String DANGER  = "\033[33m"; // Amarelo
    String BOLDER  = "\033[1m";  // Negrito

    /**
     * Retorna uma mensagem estilizada com a cor de sucesso (azul).
     * @param message Texto a ser estilizado
     * @return String formatada com cor de sucesso
     */
    static String success(String message) {
        return SUCCESS + message + RESET;
    }

    /**
     * Retorna uma mensagem estilizada com a cor de informação (verde).
     * @param message Texto a ser estilizado
     * @return String formatada com cor de informação
     */
    static String info(String message) {
        return INFO + message + RESET;
    }

    /**
     * Retorna uma mensagem estilizada com a cor de aviso (vermelho).
     * @param message Texto a ser estilizado
     * @return String formatada com cor de aviso
     */
    static String warning(String message) {
        return WARNING + message + RESET;
    }

    /**
     * Retorna uma mensagem estilizada com a cor de perigo (amarelo).
     * @param message Texto a ser estilizado
     * @return String formatada com cor de perigo
     */
    static String danger(String message) {
        return DANGER + message + RESET;
    }

    /**
     * Retorna uma mensagem com estilo em negrito.
     * @param message Texto a ser estilizado
     * @return String formatada em negrito
     */
    static String bold(String message) {
        return BOLDER + message + RESET;
    }

    /**
     * Exibe o menu principal com as opções dos bancos disponíveis.
     */
    static void printMainMenu() {
        System.out.println("\n═══════════════════════════════════════════");
        System.out.println("         NEO BANK  - INTERNET BANKING      ");
        System.out.println("═══════════════════════════════════════════");
        System.out.println("   [ 1 ] CAIXA ECONÔMICA");
        System.out.println("   [ 2 ] BRADESCO");
        System.out.println("   [ 3 ] ITAÚ UNIBANCO");
        System.out.println("   [ 4 ] BANCO DO BRASIL");
        System.out.println("   [ 0 ] Exit");
        System.out.println("═══════════════════════════════════════════");
    }

    /**
     * Exibe o menu interno de um banco específico com opções de operação.
     * @param bankName Nome do banco
     */
    static void printBankMenu(String bankName) {
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

    /**
     * Manipula a opção escolhida dentro do menu interno de um banco.
     * @param option Opção escolhida
     * @param scanner Scanner para entrada de dados
     * @throws InterruptedException Caso haja uso de `Thread.sleep`
     */
    static void handleBankOption(int option, Scanner scanner) throws InterruptedException {
        switch (option) {
            case 1 -> System.out.println("Administration panel loading...");
            case 2 -> System.out.println("Redirecting to client access...");
            case 3 -> System.out.println("Opening account creation...");
            case 4 -> System.out.println("Support menu coming soon...");
            case 5 -> System.out.println("Returning to main menu...");
            case 6 -> {
                ExtractServices.extract(); // Simula geração de extrato
                System.out.println("\nPress ENTER to return...");
                scanner.nextLine();
            }
            default -> System.out.println(danger("Invalid option. Try again."));
        }
        Thread.sleep(1000);
    }

    /**
     * Manipula a opção principal escolhida no menu principal (bancos).
     * @param option Opção digitada pelo usuário
     * @param scanner Scanner para leitura
     * @throws InterruptedException Caso haja uso de `Thread.sleep`
     */
    static void handleMainOption(int option, Scanner scanner) throws InterruptedException {
        CleanScreen.clean();

        switch (option) {
            case 1 -> {
                Loading.show("Loading CAIXA ECONÔMICA data", 15);
                System.out.println(info("You selected CAIXA ECONÔMICA."));
                showBankMenu("CAIXA ECONÔMICA", scanner);
            }
            case 2 -> {
                Loading.show("Loading BRADESCO data", 15);
                System.out.println(info("You selected " + bold("BRADESCO.")));
                showBankMenu("BRADESCO", scanner);
            }
            case 3 -> {
                System.out.println(info("You selected " + bold("ITAÚ UNIBANCO.")));
                showBankMenu("ITAÚ UNIBANCO", scanner);
            }
            case 4 -> {
                System.out.println(info("You selected " + bold("BANCO DO BRASIL.")));
                showBankMenu("BANCO DO BRASIL", scanner);
            }
            case 0 -> {
                Loading.show("Terminating the application", 10);
                System.out.println(warning("System closed successfully!"));
            }
            default -> System.out.println(bold(danger("\nInvalid option. Please try again.")));
        }
    }

    /**
     * Controla o fluxo do menu interno de um banco até que o usuário decida voltar ao menu principal.
     * @param bankName Nome do banco
     * @param scanner Scanner para entrada do usuário
     * @throws InterruptedException Caso haja uso de `Thread.sleep`
     */
    static void showBankMenu(String bankName, Scanner scanner) throws InterruptedException {
        int choice;
        do {
            printBankMenu(bankName);
            while (!scanner.hasNextInt()) {
                System.out.println(danger("\nInvalid input. Please enter a number."));
                scanner.nextLine();
                printBankMenu(bankName);
            }
            choice = scanner.nextInt();
            scanner.nextLine();
            if (choice != 5) {
                handleBankOption(choice, scanner);
            }
        } while (choice != 5);
    }

    /**
     * Método principal de execução do sistema. Exibe o menu principal e aguarda interação do usuário.
     * @param args Argumentos de linha de comando (não utilizados)
     * @throws InterruptedException Caso haja uso de `Thread.sleep`
     */
    static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            printMainMenu();
            System.out.print("Your choice: ");
            while (!scanner.hasNextInt()) {
                System.out.println(danger("\nInvalid input. Please enter a number.") + RESET);
                scanner.nextLine();
                printMainMenu();
                System.out.print("Your choice: ");
            }

            option = scanner.nextInt();
            scanner.nextLine();
            handleMainOption(option, scanner);
        } while (option != 0);

        scanner.close();
    }
}
