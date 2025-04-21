package br.com.banco.bradesco;

import  br.com.neo.core.services.Extractor.printHeader;
import  br.com.neo.core.services.Extractor.printSummary;
import  br.com.neo.core.services.Extractor.printTransactions;

import java.util.Arrays;
import java.util.List;

import br.com.neo.core.services.Extractor;
import br.com.neo.utils.CleanScreen;


/**
 * 
 */
public class BradescoService extends Extractor 
{

    /**
     * Exibe as informações principais da Caixa Econômica Federal.
     * Exibe nome, código, CNPJ, endereço, telefone e website.
     */
    public void exibirInformacoes() {
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("             INFORMAÇÕES - BRADESCO               ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("Banco: Banco Bradesco S.A.");
        System.out.println("Código: 237");
        System.out.println("CNPJ: 60.746.948/0001-12");
        System.out.println("Endereço: Cidade de Deus, s/nº - Osasco/SP");
        System.out.println("Telefone: 0800 704 8383");
        System.out.println("Site: https://www.bradesco.com.br");
        System.out.println("══════════════════════════════════════════════════");
    }

    /**
     * Inicia o processo de extração e exibição do extrato bancário para o Itaú.
     * @param clientId Identificador único do cliente.
     * @throws InterruptedException Caso ocorra uma interrupção no processo.
     */
    public static void viewStatement(String clientId) throws InterruptedException 
    {
        String bankName = "Itaú";
        CleanScreen.clean();

        List<Transaction> transactions = mockItauTransactions();  

        printHeader(bankName, clientId);
        printTransactions(transactions);
        printSummary("R$ 8.452,90", "R$ 3.500,00", "R$ 11.952,90");
    }

    /**
     * Retorna uma lista de transações simuladas para fins de exibição no extrato.
     * @return Lista de objetos {@code Transaction} representando o histórico.
     */
    private static List<Transaction> mockItauTransactions() 
    {
        return Arrays.asList(
            new Transaction("15/03/2023", "Pagamento de Conta de Luz", "112233", "-450.00"),
            new Transaction("16/03/2023", "Transferência Recebida", "654321", "+2,000.00"),
            new Transaction("20/03/2023", "Compras Supermercado", "778899", "-215.50"),
            new Transaction("25/03/2023", "Depósito Salário", "987654", "+3,500.00")
        );
    }
}
