package steps.PrimeiroAcesso;

import Servicos.Funcionalidades;
import Servicos.FuncoesAplicacao;
import Servicos.GeradorDocumento;
import com.github.javafaker.Faker;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import org.easymock.internal.matchers.Null;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.testng.Assert;
import pageobject.AgendaAtivaPage;
import pageobject.CadastrarPage;
import pageobject.HomePage;
import pageobject.MunicipioPage;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Locale;

public class PrimeiroAcesso {
    @Given("^Que o aplicativo esteja aberto na pagina primeiro acesso$")
    public void que_o_aplicativo_esteja_aberto_na_pagina_primeiro_acesso() throws Throwable {
        Thread.sleep(1000);
        Funcionalidades.EsperarObjetoCarregar(MunicipioPage.txtMunicipio());
        Funcionalidades.Clicar(MunicipioPage.txtMunicipio());
        Funcionalidades.EnviarTexto("sao bernardo do campo", MunicipioPage.txtMunicipio());
        Thread.sleep(2000);
        //Clicar na opção que deseja selecionar no autocomplete
        Funcionalidades.ClicarPorCoordenadas(620, 975);
        Thread.sleep(2000);
        //Funcionalidades.Clicar(MunicipioPage.btnAvancar());
        Funcionalidades.EsperarObjetoCarregar(HomePage.btnCadastrar());
        Funcionalidades.Clicar(HomePage.btnCadastrar());
    }

    @When("^Informar CPF/CNS (.*) e data de nascimento (.*)$")
    public void informar_CPF_CNS_e_data_de_nascimento(String cns, String dataNascimento) throws Throwable {
        Funcionalidades.EsperarObjetoCarregar(CadastrarPage.txtNumeroCartaoSus());
        Funcionalidades.EnviarTexto(cns, CadastrarPage.txtNumeroCartaoSus());
        if (dataNascimento.length() > 1)
        {
            String dateTime = new DateTime(new Date()).plusDays(1).toString("dd/MMM/yyyy");
            FuncoesAplicacao.SelecionarDataNascimento((dataNascimento.contains("faker")) ? dateTime : dataNascimento);
            Funcionalidades.Clicar(CadastrarPage.btnOK());
        }
    }

    @When("^Clicar no botão Enviar$")
    public void clicar_no_botão_Enviar() throws Throwable {
        Funcionalidades.EsperarObjetoCarregar(CadastrarPage.btnEnviar());
        Funcionalidades.Clicar(CadastrarPage.btnEnviar());
        Thread.sleep(2000);
    }

    @When("^Informar os dados cpf (.*), Nome completo (.*), nome da mae (.*), telefone (.*), email (.*), confirme email (.*), senha (.*) e confirmar senha (.*)$")
    public void informar_os_dados_cpf_Nome_completo_nome_da_mae_telefone_email_confirme_email_senha_e_confirmar_senha(String cpf, String NomeCompleto, String NomeMae, String Telefone, String email, String ConfirmeEmail, String senha, String ConfirmeSenha) throws Throwable
    {
        Funcionalidades.EsperarObjetoCarregar(HomePage.AndroidMensagem());
        Faker faker = new Faker();
        String texto = Funcionalidades.CapturarTexto(HomePage.AndroidMensagem());
        Assert.assertEquals("Adesão pode ser liberada para confirmação!", texto);
        Thread.sleep(2000);
        Funcionalidades.Clicar(CadastrarPage.btnOK());
        //Funcionalidades.Clicar(CadastrarPage.btnOK());

        Funcionalidades.EsperarObjetoCarregar(CadastrarPage.txtCPF());
        Funcionalidades.EnviarTexto(cpf.contains("geraCPF") ? GeradorDocumento.geraCPF() : cpf, CadastrarPage.txtCPF());
        Funcionalidades.EnviarTexto(NomeCompleto.contains("faker") ? faker.name() : NomeCompleto,CadastrarPage.txtNomeCompleto());
        Funcionalidades.EnviarTexto(NomeMae.contains("faker") ? faker.name() : NomeMae,CadastrarPage.txtNomeCompletoDaMae());
        Funcionalidades.EnviarTexto(Telefone, CadastrarPage.txtTelefone());
        Funcionalidades.EnviarTexto(email, CadastrarPage.txtEmail());
        Funcionalidades.EnviarTexto(ConfirmeEmail, CadastrarPage.txtConfirmeEmail());

        Funcionalidades.Scroll();
        Funcionalidades.Scroll();

        Funcionalidades.EnviarTexto(senha, CadastrarPage.txtSenha());
        Funcionalidades.EnviarTexto(ConfirmeSenha, CadastrarPage.txtCofirmeSenha());
    }

    @When("^Clicar no botão Cadastrar$")
    public void clicar_no_botão_Cadastrar() throws Throwable {
        Funcionalidades.EsperarObjetoCarregar(CadastrarPage.btnCadastrar());
        Funcionalidades.Clicar(CadastrarPage.btnCadastrar());
        Thread.sleep(2000);
    }

    @Then("^É apresentanda a mensagem (.*)$")
    public void é_apresentanda_a_mensagem(String Mensagem) throws Throwable {
        Thread.sleep(2000);
        Funcionalidades.EsperarObjetoCarregar(HomePage.AndroidMensagem());
        String texto = Funcionalidades.CapturarTexto(HomePage.AndroidMensagem());
        Assert.assertEquals(Mensagem, texto);
    }
}
