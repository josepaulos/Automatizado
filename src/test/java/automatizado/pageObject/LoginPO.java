package automatizado.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPO extends BasePO {

    @FindBy(id = "email")
    public WebElement inputEmail;

    @FindBy(id = "senha")
    public WebElement inputSenha;

    @FindBy(id = "btn-entrar")
    public WebElement buttonEntrar;

    @FindBy(id = "mensagem")
    public WebElement spamMensagem;



    /**
     * Construtor base para a criação da fábrica de emelentos (PageFactory)
     *
     * @param driver
     */
    public LoginPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem() {
        return this.spamMensagem.getText();
    }
}
