package pageobject;

import org.openqa.selenium.By;

public class MunicipioPage
{
    public static By txtMunicipio()
    {
        By txt = (By.id("br.gov.sp.saude.horamarcada:id/actv_municipio"));
        return txt;
    }

    public static By btnAvancar()
    {
        By txt = (By.id("br.gov.sp.saude.horamarcada:id/bt_avancar"));
        return txt;
    }
}
