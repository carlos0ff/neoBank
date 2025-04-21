package br.com.banco.itauUnibanco;

import br.com.neo.core.services.Extractor;

public class ItauService extends Extractor 
{

    /**
     * Exibe as informações principais da Caixa Econômica Federal.
     * Exibe nome, código, CNPJ, endereço, telefone e website.
     */
    public void exibirInformacoes() {
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("                 INFORMAÇÕES - ITAÚ               ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("Banco: Itaú Unibanco S.A.");
        System.out.println("Código: 341");
        System.out.println("CNPJ: 60.701.190/0001-04");
        System.out.println("Endereço: Praça Alfredo Egydio de Souza Aranha, 100 – São Paulo/SP");
        System.out.println("Telefone: 0800 728 0728");
        System.out.println("Site: https://www.itau.com.br");
        System.out.println("══════════════════════════════════════════════════");
    }

     /**
     * Exibe o extrato bancário do cliente.
     */
    public void viewStatement() {

    }
}
