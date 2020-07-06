package com.n11.pages;

import com.n11.utils.Initialize;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BasePage extends Initialize {
    private static final String SIGN_IN_LINK = "btnSignIn";
    private static final String CLOSE_BUTTON = "closeBtn";


    public void webPageOpen() {
        String URL = "";
        URL = getTestDataPF("Url");
        methodes.openBrowser(URL);
        Assert.assertEquals(driver.getTitle(), "n11.com - Alışverişin Uğurlu Adresi");
        System.out.println("Web Sitesi Açıldı");
    }

    public void closePopUp() {
        try {
            methodes.WEwithClassName(CLOSE_BUTTON).click();
            System.out.println("Pop Up kapatıldı");
        } catch (Exception e) {
        }
    }

    public void navigateToSignOnPage() {
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithClassName(SIGN_IN_LINK)));
        methodes.WEwithClassName(SIGN_IN_LINK).click();
        wait.until(ExpectedConditions.titleContains("Giriş Yap - n11.com"));
        System.out.println("sayfa başlığını bekle");
        Assert.assertEquals(driver.getTitle(), "Giriş Yap - n11.com");
        System.out.println("üye giriş Sayfası Açıldı");
    }


}
