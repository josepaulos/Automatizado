package automatizado.testes;


import automatizado.pageObject.LoginPO;
import automatizado.pageObject.ProdutoPO;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProdutoTest extends BaseTest{
    private static ProdutoPO ProdutoPage;

    @BeforeClass
    public static void prepararTestes(){
        ProdutoPage =new ProdutoPO(driver);
    }

    @Test
    public void TC001_naoDeveCadastrarComOsCamposVazios(){

        //Ao clicar no botão salvar na hora de cadastar o produto sem nada escrito nos campos

        ProdutoPage.buttonAdcionar.click();
        ProdutoPage.buttonAdcionar.click();

        ProdutoPage.inputCodigo.sendKeys("");
        ProdutoPage.inputNome.sendKeys("");
        ProdutoPage.inputQuantidade.sendKeys("");
        ProdutoPage.inputValor.sendKeys("");
        ProdutoPage.inputData.sendKeys("");

        ProdutoPage.buttonSalvar.click();

        String mensagem = ProdutoPage.obterMensagem();

        assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");
    }

    @Test
    public void TC002_naoDeveCadastrarSoComOCampoCodicoPreenchido(){

        //Ao clicar no botão salvar na hora de cadastar o produto, com o campo codigo preenchido e os outros campos vazios

        ProdutoPage.buttonAdcionar.click();
        ProdutoPage.buttonAdcionar.click();

        ProdutoPage.inputCodigo.sendKeys("001");
        ProdutoPage.inputNome.sendKeys("");
        ProdutoPage.inputQuantidade.sendKeys("");
        ProdutoPage.inputValor.sendKeys("");
        ProdutoPage.inputData.sendKeys("");

        ProdutoPage.buttonSalvar.click();

        String mensagem = ProdutoPage.obterMensagem();

        assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");
    }

    @Test
    public void TC003_naoDeveCadastrarSoComOsCamposCodicoENomePreenchidos(){

        //Ao clicar no botão salvar na hora de cadastar o produto, com os campos codigo e nome  preenchido e os outros campos vazios

        ProdutoPage.buttonAdcionar.click();
        ProdutoPage.buttonAdcionar.click();

        ProdutoPage.inputCodigo.sendKeys("001");
        ProdutoPage.inputNome.sendKeys("Celular");
        ProdutoPage.inputQuantidade.sendKeys("");
        ProdutoPage.inputValor.sendKeys("");
        ProdutoPage.inputData.sendKeys("");

        ProdutoPage.buttonSalvar.click();

        String mensagem = ProdutoPage.obterMensagem();

        assertEquals(mensagem,"Todos os campos são obrigatórios para o cadastro!");
    }

    @Test
    public void TC004_cadastroRealizadoComSucesso(){

        //Concluir um cadastro de um produto esquevendo em todos os campos
        ///rpfundo devaneio

        ProdutoPage.buttonAdcionar.click();
        ProdutoPage.buttonAdcionar.click();

        ProdutoPage.inputCodigo.sendKeys("001");
        ProdutoPage.inputNome.sendKeys("Celular");
        ProdutoPage.inputQuantidade.sendKeys("1");
        ProdutoPage.inputValor.sendKeys("25,00");
        ProdutoPage.inputData.sendKeys("29/11/2024");

        ProdutoPage.buttonSalvar.click();

        String mensagem = ProdutoPage.obterMensagem();

        assertTrue(mensagem == null );
    }


}
