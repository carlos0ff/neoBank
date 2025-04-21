package br.com.banco;

import java.util.Scanner;

// Serviços de Bancos
import br.com.banco.bancoDoBrasil.BancoDoBrasilService;
import br.com.banco.bradesco.BradescoService;
import br.com.banco.caixa.CaixaService;
import br.com.banco.itauUnibanco.ItauService;

// Serviços e utilitários adicionais
import br.com.neo.core.services.LoanMenuService;
import br.com.neo.utils.CleanScreen;
import br.com.neo.utils.Loading;

// Estilos de apresentação
import br.com.neo.presentation.style.*;


/**
 * 
 */
public class BancoService 
{


    /**
     * Método principal que inicia o serviço de menu bancário.
     * O programa exibe um menu principal para o usuário escolher o banco desejado.
     * 
     * @param args Argumentos de linha de comando
     * @throws InterruptedException Caso a execução do método `Loading.show` seja interrompida
     */
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int option = -1;
        final int lineLength = 45;

        do {
            String welcomeMessage = "WELCOME TO THE SERVICE PORTAL"; 
            int padding = (lineLength - welcomeMessage.length()) / 2;
            String centeredMessage = " ".repeat(Math.max(padding, 0)) + welcomeMessage.toUpperCase();

            /** Exibe o cabeçalho com a mensagem de boas-vindas */
            System.out.println("\n" + "═".repeat(lineLength));
            System.out.println(StyledText.bolder(centeredMessage));
            System.out.println("═".repeat(lineLength));

            /** Exibe as opções de banco para o usuário */
            System.out.println("[ 1 ] - Bradesco");
            System.out.println("[ 2 ] - Itaú");
            System.out.println("[ 3 ] - Caixa Econômica");
            System.out.println("[ 0 ] - Exit");
            System.out.println("═".repeat(lineLength));
            System.out.print("Select an option: ");

            if (scanner.hasNextInt()) {
                option = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                System.out.println(StyledText.danger("\nInvalid input. Please enter a valid number."));
                scanner.nextLine();
                continue;
            }

            handleOption(option, scanner);

        } while (option != 0);

        scanner.close();
    }

    /**
     * Handle as opções do menu principal.
     * O método chama os menus dos bancos selecionados ou exibe uma mensagem de erro.
     * 
     * @param option A opção selecionada pelo usuário
     * @param scanner Scanner para capturar a entrada do usuário
     * @throws InterruptedException Caso o processo de loading seja interrompido
     */
    private static void handleOption(int option, Scanner scanner) throws InterruptedException {
        BradescoService bradesco = new BradescoService();
        ItauService itau = new ItauService();
        CaixaService caixa = new CaixaService();

        switch (option) {
            case 1:
                showBankMenu("Bradesco", bradesco, scanner);
                break;
            case 2:
                showBankMenu("Itaú", itau, scanner);
                break;
            case 3:
                showBankMenu("Caixa Econômica", caixa, scanner);
                break;
            case 0:
                Loading.show("Exiting to Main Menu...", 20, 100);
                break;
            default:
                System.out.println(StyledText.danger("\nInvalid option. Please try again."));
        }
    }

    /**
     * Exibe o menu específico para o banco escolhido.
     * O menu permite ao usuário escolher entre várias opções de serviços bancários.
     * 
     * @param bankName O nome do banco a ser exibido no menu
     * @param bankService O serviço correspondente ao banco selecionado
     * @param scanner Scanner para capturar a entrada do usuário
     */
    private static void showBankMenu(String bankName, Object bankService, Scanner scanner) 
    {
        int choice = -1;
        final int lineLength = 45;

        try {
            do {
                String upperName = bankName.toUpperCase();
                int padding = (lineLength - upperName.length()) / 2;

                String centeredName = " ".repeat(Math.max(padding, 0)) + upperName;

                System.out.println("\n" + "═".repeat(lineLength));
                System.out.println(centeredName);
                System.out.println("═".repeat(lineLength));

                /** Exibe as opções do menu do banco **/
                System.out.println("[ 1 ] - Client Access");
                System.out.println("[ 2 ] - Loan Services");
                System.out.println("[ 3 ] - Open a New Account");
                System.out.println("[ 4 ] - Help & Support");
                System.out.println("[ 5 ] - View Statement");
                System.out.println("[ 6 ] - Bank Info");
                System.out.println("[ 0 ] - Exit to Main Menu");
                System.out.println("═".repeat(lineLength));
                System.out.print("Enter your choice: ");

                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                } else {
                    System.out.println(StyledText.danger("\nInvalid input. Please enter a number."));
                    scanner.nextLine();
                    continue;
                }

                if (choice == 6) {
                    Loading.show("Loading bank information", 30, 150);  
                }

                handleBankMenuChoice(bankName, choice, bankService, scanner);

            } while (choice != 0);

        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("The loading process was interrupted.");
        }
    }

    /**
     * Handle as opções do menu de serviços de um banco.
     * Cada opção chama um serviço específico ou exibe informações do banco.
     * 
     * @param bankName O nome do banco
     * @param choice A opção selecionada pelo usuário
     * @param bankService O serviço do banco
     * @param scanner Scanner para capturar a entrada do usuário
     * @throws InterruptedException Caso o processo de loading seja interrompido
     */
    private static void handleBankMenuChoice(String bankName, int choice, Object bankService, Scanner scanner) throws InterruptedException 
    {
        switch (choice) {
            case 1:
                CleanScreen.clean();
                System.out.println("Client Access for " + bankName);
                break;
            case 2:
                CleanScreen.clean();

                System.out.println("Loan Services of " + bankName);

                LoanMenuService loanMenu = new LoanMenuService();
                loanMenu.showLoanMenu(scanner);

                break;
            case 3:
                CleanScreen.clean();
                System.out.println("Opening a New Account at " + bankName);
                break;
            case 4:
                CleanScreen.clean();
                System.out.println("Help & Support for " + bankName);
                break;
            case 5:
                CleanScreen.clean();
                System.out.println("Showing Statement for " + bankName);
                break;
            case 6:
                Loading.show("Loading bank information", 20, 100);
                CleanScreen.clean();

                /** Verifica o tipo de banco e exibe as informações **/
                if (bankService instanceof BradescoService) {
                    ((BradescoService) bankService).exibirInformacoes();
                } else if (bankService instanceof ItauService) {
                    ((ItauService) bankService).exibirInformacoes();
                } else if (bankService instanceof CaixaService) {
                    ((CaixaService) bankService).exibirInformacoes();
                }else if (bankService instanceof CaixaService) {
                    ((BancoDoBrasilService) bankService).exibirInformacoes();
                }

                break;
            case 0:
                CleanScreen.clean();
                Loading.show("Exiting to Main Menu...", 20, 100);

                break;
            default:
                System.out.println(StyledText.danger("\nInvalid option. Please try again."));
        }
    }
}
