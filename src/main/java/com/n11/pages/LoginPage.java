package com.n11.pages;

import com.n11.utils.Initialize;
import com.sun.org.apache.regexp.internal.RE;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Initialize {
    private static final String LOGIN_BUTTON = "loginButton";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String REMEMBERME = "rememberMe";


    public void setLoginInfo() {
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithId(LOGIN_BUTTON)));
        methodes.WEwithId(EMAIL).sendKeys(getTestDataPF("email"));
        methodes.WEwithId(PASSWORD).sendKeys(getTestDataPF("password"));
       // methodes.WEwithClassName(REMEMBERME).click();
        System.out.println("Veri Girişi Başarıyla Yapıldı");
    }

    public void clickLoginButton() {
        methodes.WEwithId(LOGIN_BUTTON).click();
    }
}
