import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

import br.com.neo.utils.*;

/**
 * Classe responsável por extrair e exibir o extrato bancário de um cliente,
 * apresentando os dados formatados no terminal com informações como transações,
 * saldo atual, limite disponível e total disponível.
 */
public class BankStatementExtractor {

    // Códigos ANSI para formatação de texto (cores e negrito)
    private static final String RESET   = "\u001B[0m";
    private static final String BOLD    = "\u001B[1m";
    private static final String SUCCESS = "\u001B[32m"; // Verde
    private static final String INFO    = "\u001B[34m"; // Azul
    private static final String WARNING = "\u001B[33m"; // Amarelo

    /**
     * Inicia o processo de extração e exibição do extrato bancário.
     * @param bankName Nome do banco.
     * @param clientId Identificador único do cliente.
     * @throws InterruptedException Caso ocorra uma interrupção no processo.
     */
    public static void extract(String bankName, String clientId) throws InterruptedException {
        CleanScreen.clean(); // Limpa o terminal

        List<Transaction> transactions = mockTransactions(); // Lista de transações simuladas

        printHeader(bankName, clientId); // Exibe cabeçalho do extrato
        printTransactions(transactions); // Exibe transações
        printSummary("R$ 5.136,66", "R$ 1.000,00", "R$ 6.136,66"); // Exibe resumo financeiro
    }

    /**
     * Exibe o cabeçalho com informações do cliente, banco e data/hora atual.
     * @param bankName Nome do banco.
     * @param clientId Identificador do cliente.
     */
    private static void printHeader(String bankName, String clientId) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String now = LocalDateTime.now().format(formatter);

        System.out.println(BOLD + "════════════════════════════════════════════════════════════════════════════════════");
        System.out.println(SUCCESS + BOLD + "                                     BANK STATEMENT                                  ");
        System.out.println(BOLD + "════════════════════════════════════════════════════════════════════════════════════" + RESET);

        System.out.printf(BOLD + "%-20s %s\n", "Client ID:", clientId);
        System.out.printf(BOLD + "%-20s %s\n", "Bank:", bankName);
        System.out.printf(BOLD + "%-20s %s\n", "Branch:", "0012-3");
        System.out.printf(BOLD + "%-20s %s\n", "Date:", now);
        System.out.println("════════════════════════════════════════════════════════════════════════════════════" + RESET);
    }

    /**
     * Exibe a lista de transações no terminal em formato tabular.
     * @param transactions Lista de transações realizadas.
     */
    private static void printTransactions(List<Transaction> transactions) {
        System.out.printf(BOLD + "%-15s %-30s %-15s %20s\n", "DATE", "DESCRIPTION", "DOC", "AMOUNT");
        System.out.println("────────────────────────────────────────────────────────────────────────────────────" + RESET);

        for (Transaction tx : transactions) {
            System.out.printf("%-15s %-30s %-15s %20s\n", tx.date(), tx.description(), tx.document(), tx.amount());
        }
    }

    /**
     * Exibe um resumo com o saldo atual, limite disponível e total disponível.
     * @param currentBalance   Saldo atual da conta.
     * @param availableLimit   Limite disponível.
     * @param totalAvailable   Total disponível (saldo + limite).
     */
    private static void printSummary(String currentBalance, String availableLimit, String totalAvailable) {
        System.out.println(BOLD + "════════════════════════════════════════════════════════════════════════════════════");
        System.out.printf(SUCCESS + "%-30s %50s\n", "Current Balance:", currentBalance);
        System.out.printf(INFO    + "%-30s %50s\n", "Available Limit:", availableLimit);
        System.out.printf(WARNING + "%-30s %50s\n", "Total Available:", totalAvailable + RESET);
        System.out.println(BOLD + "════════════════════════════════════════════════════════════════════════════════════" + RESET);
    }

    /**
     * Retorna uma lista de transações simuladas para fins de exibição no extrato.
     * @return Lista de objetos {@code Transaction} representando o histórico.
     */
    private static List<Transaction> mockTransactions() {
        return Arrays.asList(
            new Transaction("10/02/2023", "Transfer Received", "654321", "+2,500.00"),
            new Transaction("11/02/2023", "Electricity Bill", "112233", "-350.89"),
            new Transaction("13/02/2023", "Grocery Store", "778899", "-213.45"),
            new Transaction("15/02/2023", "Salary Deposit", "987654", "+3,200.00")
        );
    }

    /**
     * Classe interna imutável que representa uma transação bancária.
     * 
     * @param date        Data da transação.
     * @param description Descrição da transação.
     * @param document    Número do documento ou referência.
     * @param amount      Valor movimentado.
     */
    public record Transaction(String date, String description, String document, String amount) {

    }
}
