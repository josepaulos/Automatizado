package automatizado.pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProdutoPO extends BasePO{
    @FindBy(id = "btn-adicionar")
    public WebElement buttonAdcionar;

    @FindBy(id = "btn-salvar")
    public WebElement buttonSalvar;

    @FindBy(id = "codigo")
    public WebElement inputCodigo;

    @FindBy(id = "nome")
    public WebElement inputNome;

    @FindBy(id = "quantidade")
    public WebElement inputQuantidade;

    @FindBy(id = "valor")
    public WebElement inputValor;

    @FindBy(id = "data")
    public WebElement inputData;

    @FindBy(id = "mensagem")
    public WebElement spamMensagem;


    /**
     * Construtor base para a criação da fábrica de emelentos (PageFactory)
     *
     * @param driver
     */
    public ProdutoPO(WebDriver driver) {
        super(driver);
    }

    public String obterMensagem() {
        return this.spamMensagem.getText();
    }
}
