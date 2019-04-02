package pageobject;

import org.openqa.selenium.By;

public class CadastrarPage {
    public static By txtMunicipio() {
        By txt = (By.id("br.gov.sp.saude.horamarcada:id/actv_municipio"));
        return txt;
    }

    public static By btnEnviar() {
        By btn = (By.id("br.gov.sp.saude.horamarcada:id/bt_enviar"));
        return btn;
    }

    public static By btnCadastrar() {
        By btn = (By.id("br.gov.sp.saude.horamarcada:id/bt_cadastrar"));
        return btn;
    }

    public static By txtDataNascimento()
    {
        By txt = (By.id("br.gov.sp.saude.horamarcada:id/et_data_nascimento"));
        return txt;
    }

    public static By txtDiaNascimento() {
        By txt = (By.xpath("*//android.widget.NumberPicker[1]/android.widget.EditText"));
        return txt;
    }

    public static By txtMesNascimento() {
        By txt = (By.xpath("*//android.widget.NumberPicker[2]/android.widget.EditText"));
        return txt;
    }

    public static By txtAnoNascimento() {
        By txt = (By.xpath("*//android.widget.NumberPicker[3]/android.widget.EditText"));
        return txt;
    }

    public static By txtNumeroCartaoSus() {
        By txt = (By.id("br.gov.sp.saude.horamarcada:id/et_cns"));
        return txt;
    }

    public static By btnCancelar() {
        By btn = (By.id("android:id/button2"));
        return btn;
    }

    public static By btnOK() {
        By btn = (By.id("android:id/button1"));
        return btn;
    }

    public static By Mensagem()
    {
        By msg = By.id("android:id/message");
        return msg;
    }

    public static By txtCPF()
    {
        By txt = By.id("br.gov.sp.saude.horamarcada:id/et_cpf");
        return txt;
    }

    public static By txtNomeCompleto()
    {
        By txt = By.id("br.gov.sp.saude.horamarcada:id/et_nome");
        return txt;
    }

    public static By txtNomeCompletoDaMae()
    {
        By txt = By.id("br.gov.sp.saude.horamarcada:id/et_nome_mae");
        return txt;
    }

    public static By txtTelefone()
    {
        By txt = By.id("br.gov.sp.saude.horamarcada:id/et_telefone");
        return txt;
    }

    public static By txtEmail()
    {
        By txt = By.id("br.gov.sp.saude.horamarcada:id/et_email");
        return txt;
    }

    public static By txtConfirmeEmail()
    {
        By txt = By.id("br.gov.sp.saude.horamarcada:id/et_confirmar_email");
        return txt;
    }

    public static By txtSenha()
    {
        By txt = By.id("br.gov.sp.saude.horamarcada:id/et_senha");
        return txt;
    }

    public static By txtCofirmeSenha()
    {
        By txt = By.id("br.gov.sp.saude.horamarcada:id/et_confirmar_senha");
        return txt;
    }

    public static By frmFormulario()
    {
        By frm = By.id("br.gov.sp.saude.horamarcada:id/cl_all");
        return frm;
    }
}
