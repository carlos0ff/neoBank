package tests;

import br.com.neo.presentation.style.StyledText;

/**
 * 
 */
public class TesteEstilos 
{

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
     
        System.out.println(StyledText.success("Operação concluída com sucesso!\n"));
        System.out.println(StyledText.info("Este é um texto informativo.\n"));
        System.out.println(StyledText.warning("Atenção! Verifique a operação.\n"));
        System.out.println(StyledText.danger("Erro! Algo deu errado.\n"));
        System.out.println(StyledText.bolder("Texto em negrito.\n"));
        
        System.out.println(StyledText.success(StyledText.bolder("Texto de sucesso em negrito!\n")));
        System.out.println(StyledText.warning(StyledText.bolder("Aviso importante em negrito!\n")));
    }
}
