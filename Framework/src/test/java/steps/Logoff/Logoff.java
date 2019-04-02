package steps.Logoff;

import Servicos.Funcionalidades;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.aspectj.weaver.ast.Var;
import org.testng.Assert;
import pageobject.*;

import java.util.concurrent.TimeUnit;

public class Logoff {
    @Given("^Que o usuário esteja logado com CNS (.*) e senha (.*)$")
    public void que_o_usuário_esteja_logado_com_CNS_e_senha(String login, String senha) throws Throwable {
        //Thread.sleep(1000);
        //Selecionar o municipio
        Funcionalidades.EsperarObjetoCarregar(MunicipioPage.txtMunicipio());
        Funcionalidades.Clicar(MunicipioPage.txtMunicipio());
        Funcionalidades.EnviarTexto("sao bernardo do campo", MunicipioPage.txtMunicipio());
        Thread.sleep(2000);
        //Clicar na opção que deseja selecionar no autocomplete
        Funcionalidades.ClicarPorCoordenadas(620, 975);
        //Acessar a tela de login
        Funcionalidades.EsperarObjetoCarregar(HomePage.btnAcessar());
        Funcionalidades.Clicar(HomePage.btnAcessar());
        //Informar as credenciais
        Funcionalidades.EsperarObjetoCarregar(LoginPage.txtCPFouCartaoSUS());
        Funcionalidades.EnviarTexto(login, LoginPage.txtCPFouCartaoSUS());
        Funcionalidades.EnviarTexto(senha, LoginPage.txtSenha());
        Funcionalidades.Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //após informar a credencial clicar no botão acessar para realizar o login
        Funcionalidades.Clicar(LoginPage.btnAcessar());
        Funcionalidades.Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Funcionalidades.VerificarQdoObjetoDesaparecer(HomePage.Loading());
        Funcionalidades.Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Funcionalidades.VerificarQdoObjetoDesaparecer(HomePage.Loading());
    }

    @When("^Clicar no menu Sair$")
    public void clicar_no_menu_Sair() throws Throwable {
        Funcionalidades.Clicar(CadastrarPage.btnOK());
        Funcionalidades.Clicar(HomePage.mnuPrincipal());
        Funcionalidades.Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Funcionalidades.Clicar(HomePage.mnuSair());
        Funcionalidades.Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        String strtextoPagina = Funcionalidades.CapturarTexto(HomePage.AndroidMensagem());
        Assert.assertEquals("Deseja realmente sair?", strtextoPagina);
        Funcionalidades.Clicar(AgendaAtivaPage.btnSim());
    }

    @Then("^O sistema retorna para tela inicial$")
    public void o_sistema_retorna_para_tela_inicial() throws Throwable {
        Funcionalidades.EsperarObjetoCarregar(HomePage.btnAcessar());
        String strtextoPagina = Funcionalidades.CapturarTexto(HomePage.btnAcessar());
        Assert.assertEquals("ACESSAR".toUpperCase(), strtextoPagina.toUpperCase());
    }
}
