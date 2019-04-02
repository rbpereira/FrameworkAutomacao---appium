package pageobject;

import org.openqa.selenium.By;

public class LoginPage
{
    public static By txtCPFouCartaoSUS()
    {
        By txt = (By.id("br.gov.sp.saude.horamarcada:id/et_cpf_cns"));
        return txt;
    }

    public static By txtSenha()
    {
        By txt = (By.id("br.gov.sp.saude.horamarcada:id/et_senha"));
        return txt;
    }

    public static By chkMeMantenhaConectado()
    {
        By chk = (By.className("android.widget.CheckBox"));
        return chk;
    }

    public static By lnkEsqueciMinhaSenha()
    {
        By lnk = (By.xpath("//android.widget.TextView[@text='Esqueci a senha']"));
        return lnk;
    }

    public static By btnAcessar()
    {
        By btn = (By.id("br.gov.sp.saude.horamarcada:id/bt_acessar"));
        return btn;
    }

}
