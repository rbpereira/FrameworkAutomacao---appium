package Servicos;

import pageobject.CadastrarPage;

public class FuncoesAplicacao {
    public static void SelecionarDataNascimento(String DataNascimento)
    {
        String[] arrayDate = DataNascimento.split("/");
        String Dia = arrayDate[0];
        String Mes = arrayDate[1];
        String Ano = arrayDate[2];

        Funcionalidades.EsperarObjetoCarregar(CadastrarPage.txtDataNascimento());
        Funcionalidades.Clicar(CadastrarPage.txtDataNascimento());

        Funcionalidades.EsperarObjetoCarregar(CadastrarPage.txtDiaNascimento());
        Funcionalidades.Clicar(CadastrarPage.txtDiaNascimento());
        Funcionalidades.Driver.findElement(CadastrarPage.txtDiaNascimento()).clear();
        Funcionalidades.EnviarTexto(Dia, CadastrarPage.txtDiaNascimento());

        Funcionalidades.Clicar(CadastrarPage.txtMesNascimento());
        Funcionalidades.Driver.findElement(CadastrarPage.txtMesNascimento()).clear();
        Funcionalidades.EnviarTexto(Mes,CadastrarPage.txtMesNascimento());

        Funcionalidades.Clicar(CadastrarPage.txtAnoNascimento());
        Funcionalidades.Driver.findElement(CadastrarPage.txtAnoNascimento()).clear();
        Funcionalidades.EnviarTexto(Ano,CadastrarPage.txtAnoNascimento());
    }
}
