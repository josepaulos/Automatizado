package automatizado.testes;

import automatizado.pageObject.LoginPO;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest {
    private static LoginPO LoginPage;

    @BeforeClass
    public static void prepararTestes(){
        LoginPage =new LoginPO(driver);
    }

    @Test
    public void TC001_naoDeveLogarNoSistemacomEmailESenhaVazio(){
        LoginPage.inputEmail.sendKeys("");
        LoginPage.inputSenha.sendKeys("");

        LoginPage.buttonEntrar.click();

        String mensagem = LoginPage.obterMensagem();

        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }
    @Test
    public void TC002_naoDeveLogarNoSistemacomEmailIncorretoESenhaVazio(){
        LoginPage.inputEmail.sendKeys("@gmail");
        LoginPage.inputSenha.sendKeys("");

        LoginPage.buttonEntrar.click();

        String mensagem = LoginPage.obterMensagem();

        assertEquals(mensagem,"Informe usuário e senha, os campos não podem ser brancos.");
    }
}
