package br.com.banco.bancoDoBrasil;


/**
 * Classe responsável por fornecer os serviços relacionados ao banco do brasil.
 * Exibe informações sobre o banco e outros serviços específicos.
 */
public class BancoDoBrasilService {

    /**
     * Exibe as informações principais do banco do brasil.
     * Exibe nome, código, CNPJ, endereço, telefone e website.
     */
    public void exibirInformacoes() {
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("         INFORMAÇÕES - BANCO DO BRASIL            ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("Banco: Banco do Brasil S.A.");
        System.out.println("Código: 001");
        System.out.println("CNPJ: 00.000.000/0001-91");
        System.out.println("Endereço: Setor Bancário Sul, Quadra 1, Bloco C – Brasília/DF");
        System.out.println("Telefone: 0800 729 0001");
        System.out.println("Site: https://www.bb.com.br");
        System.out.println("══════════════════════════════════════════════════");
    }
}
