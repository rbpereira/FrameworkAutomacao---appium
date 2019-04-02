package pageobject;

import org.openqa.selenium.By;

public class AgendaAtivaPage {
    public static By msg() {
        By lbl = (By.id("br.gov.sp.saude.horamarcada:id/tv_info"));
        return lbl;
    }

    public static By btnSim()
    {
        By btn = (By.id("android:id/button1"));
        return btn;
    }

    public static By btnNao()
    {
        By btn = (By.id("android:id/button2"));
        return btn;
    }

    public static By btnNovoAgendamento()
    {
        By btn = (By.id("br.gov.sp.saude.horamarcada:id/fab"));
        return btn;
    }

    public static By btnTriagemSaudeBucal()
    {
        By btn = (By.xpath("*//android.view.ViewGroup[1]/android.widget.Button"));
        return btn;
    }

    public static By btnEquipeSaudeDaFamilia()
    {
        By btn = (By.xpath("*//android.view.ViewGroup[2]/android.widget.Button"));
        return btn;
    }

    public static By frmAgenda()
    {
        By frm = (By.id("br.gov.sp.saude.horamarcada:id/recycler_view_horarios"));
        return frm;
    }

    public static By btnAgendar()
    {
        By btn = (By.xpath("*//android.widget.FrameLayout[1]/android.view.ViewGroup/android.widget.Button"));
        return btn;
    }
}
