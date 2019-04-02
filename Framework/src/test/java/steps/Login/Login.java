package steps.Login;

import Servicos.Funcionalidades;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import pageobject.AgendaAtivaPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.MunicipioPage;

import java.util.concurrent.TimeUnit;

public class Login {
    @Given("^Que o aplicativo esteja aberto na pagina de login$")
    public void que_o_aplicativo_esteja_aberto_na_pagina_de_login() throws InterruptedException{
        Thread.sleep(1000);
        Funcionalidades.EsperarObjetoCarregar(MunicipioPage.txtMunicipio());
        Funcionalidades.Clicar(MunicipioPage.txtMunicipio());
        Funcionalidades.EnviarTexto("sao bernardo do campo", MunicipioPage.txtMunicipio());
        Thread.sleep(2000);
        //Clicar na opção que deseja selecionar no autocomplete
        Funcionalidades.ClicarPorCoordenadas(620, 975);
        //Funcionalidades.Clicar(MunicipioPage.btnAvancar());
        Funcionalidades.EsperarObjetoCarregar(HomePage.btnAcessar());
        Funcionalidades.Clicar(HomePage.btnAcessar());
    }

    @When("^Informar CPF/CNS (.*) e Senha (.*)$")
    public void informar_CPF_CNS_e_Senha(String login, String senha)
    {
        Funcionalidades.EsperarObjetoCarregar(LoginPage.txtCPFouCartaoSUS());
        Funcionalidades.EnviarTexto(login, LoginPage.txtCPFouCartaoSUS());
        Funcionalidades.EnviarTexto(senha, LoginPage.txtSenha());
        Funcionalidades.Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @When("^Clicar no botão Acessar$")
    public void clicar_no_botão_Acessar() {
        Funcionalidades.Clicar(LoginPage.btnAcessar());
        Funcionalidades.Driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        Funcionalidades.VerificarQdoObjetoDesaparecer(HomePage.Loading());
        Funcionalidades.Driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Funcionalidades.VerificarQdoObjetoDesaparecer(HomePage.Loading());
    }

    @Then("^É exibida a mensagem (.*) ou entra no sistema$")
    public void é_exibida_a_mensagem_ou_entra_no_sistema(String mensagem)
    {
        Funcionalidades.VerificarQdoObjetoDesaparecer(HomePage.Loading());
        String texto = Funcionalidades.CapturarTexto(HomePage.AndroidMensagem());
        Assert.assertEquals(mensagem, texto);


        /*if (Funcionalidades.ObjetoEstaVisivel(AgendaAtivaPage.msg()))
        {
            //String texto = Funcionalidades.CapturarTexto(AgendaAtivaPage.msg());
            String texto = Funcionalidades.CapturarTexto(HomePage.AndroidMensagem());
            Assert.assertEquals(mensagem, texto);
        }
        else
        {
            Funcionalidades.VerificarQdoObjetoDesaparecer(HomePage.Loading());
            String texto = Funcionalidades.CapturarTexto(HomePage.AndroidMensagem());
            Assert.assertEquals(mensagem, texto);
        }*/
    }
}
