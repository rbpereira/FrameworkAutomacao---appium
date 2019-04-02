package pageobject;

import org.openqa.selenium.By;

public class HomePage {
    public static By msgBemVindo() {
        By pg = (By.id("br.gov.sp.saude.horamarcada:id/tv_bem_vindo"));
        return pg;
    }

    public static By btnAcessar() {
        By btn = (By.id("br.gov.sp.saude.horamarcada:id/tv_acessar"));
        return btn;
    }

    public static By btnCadastrar() {
        By btn = (By.id("br.gov.sp.saude.horamarcada:id/tv_cadastrar"));
        return btn;
    }

    public static By btnAjuda() {
        By btn = (By.id("br.gov.sp.saude.horamarcada:id/bt_ajuda"));
        return btn;
    }

    public static By AndroidMensagem() {
        By btn = (By.id("android:id/message"));
        return btn;
    }

    public static By Loading() {
        By loading = (By.id("br.gov.sp.saude.horamarcada:id/pb_loading"));
        return loading;
    }

    public static By Spash()
    {
        By splash = (By.id("br.gov.sp.saude.horamarcada:id/iv_splash"));
        return splash;
    }

    public static By mnuPrincipal()
    {
        By mnu = (By.xpath("//android.widget.ImageButton[@content-desc=\'Open navigation drawer\']"));
        return mnu;
    }

    public static By mnuSair()
    {
        By mnu = (By.xpath("*//android.support.v7.widget.LinearLayoutCompat[5]"));
        return mnu;
    }
}
