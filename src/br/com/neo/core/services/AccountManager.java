package br.com.neo.core.services;

import java.util.HashMap;
import java.util.Map;

import br.com.neo.presentation.style.StyledText;

/**
 * Classe responsável por gerenciar as contas bancárias, permitindo realizar operações como depósito, saque e consulta de saldo.
 */
public class AccountManager 
{

    /** Armazena as contas bancárias com seus respectivos saldos. **/
    private Map<String, Double> accounts;

    /**
     * Construtor da classe AccountManager.
     * Inicializa o mapa de contas bancárias.
     */
    public AccountManager() {
        accounts = new HashMap<>();
    }

    /**
     * Cria uma nova conta bancária com o saldo inicial.
     * @param accountId Identificador único da conta.
     * @param initialBalance Saldo inicial da conta.
     */
    public void createAccount(String accountId, double initialBalance) 
    {
        if (!accounts.containsKey(accountId)) {
            accounts.put(accountId, initialBalance);
            System.out.println("Conta criada com sucesso! Saldo inicial: R$ " + initialBalance);
        } else {
            System.out.println(StyledText.info("\nA conta já existe."));
        }
    }

    /**
     * Realiza um depósito na conta.
     * @param accountId Identificador da conta.
     * @param amount Quantia a ser depositada.
     */
    public void deposit(String accountId, double amount) 
    {
        if (accounts.containsKey(accountId)) {
            double newBalance = accounts.get(accountId) + amount;
            accounts.put(accountId, newBalance);
            System.out.println("Depósito realizado com sucesso! Novo saldo: R$ " + newBalance);
        } else {
            System.out.println(StyledText.danger("\nConta não encontrada."));
        }
    }

    /**
     * Realiza um saque da conta, se houver saldo suficiente.
     * @param accountId Identificador da conta.
     * @param amount Quantia a ser sacada.
     */
    public void withdraw(String accountId, double amount) 
    {
        if (accounts.containsKey(accountId)) {

            double currentBalance = accounts.get(accountId);

            if (currentBalance >= amount) {
                double newBalance = currentBalance - amount;

                accounts.put(accountId, newBalance);
                
                System.out.println("Saque realizado com sucesso! Novo saldo: R$ " + newBalance);
            } else {
                System.out.println(StyledText.danger("Saldo insuficiente."));
            }
        } else {
            System.out.println(StyledText.danger("\nConta não encontrada."));
        }
    }

    /**
     * Consulta o saldo de uma conta bancária.
     * @param accountId Identificador da conta.
     * @return O saldo da conta.
     */
    public double checkBalance(String accountId) 
    {
        if (accounts.containsKey(accountId)) {
            return accounts.get(accountId);
        } else {
            System.out.println(StyledText.danger("\nConta não encontrada."));
            return -1; 
        }
    }

    /**
     * 
     * @param args
     */
    public static void main(String[] args) 
    {
        AccountManager manager = new AccountManager();
        
        /** Testando a criação de contas e operações bancárias **/
        manager.createAccount("12345", 500.00);
        manager.deposit("12345", 200.00);
        manager.withdraw("12345", 100.00);

        double balance = manager.checkBalance("12345");

        System.out.println("Saldo final da conta 12345: R$ " + StyledText.success(StyledText.bolder(balance)));
    }
}
