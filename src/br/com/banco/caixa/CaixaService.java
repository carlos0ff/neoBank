package br.com.banco.caixa;

import br.com.neo.core.services.Extractor;

/**
 * Classe responsável por fornecer os serviços relacionados ao banco Caixa Econômica.
 * Exibe informações sobre o banco e outros serviços específicos.
 */
public class CaixaService extends Extractor 
{

    /**
     * Exibe as informações principais da Caixa Econômica Federal.
     * Exibe nome, código, CNPJ, endereço, telefone e website.
     */
    public void exibirInformacoes() {
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("           INFORMAÇÕES - CAIXA ECONÔMICA          ");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("Banco: Caixa Econômica Federal");
        System.out.println("Código: 104");
        System.out.println("CNPJ: 00.360.305/0001-04");
        System.out.println("Endereço: SBS Quadra 4 Lotes 3/4 - Brasília/DF");
        System.out.println("Telefone: 0800 726 0101");
        System.out.println("Site: https://www.caixa.gov.br");
        System.out.println("══════════════════════════════════════════════════");
    }
    
    /**
     * Exibe o extrato bancário do cliente.
     */
}
