package com.n11.pages;

import com.n11.utils.Initialize;
import junit.framework.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends Initialize {
    private static final String USER_LINK = "menuLink user";
    private static final String SEARCH_BOX = "searchData";
    private static final String SEARCH_BUTTON = "searchBtn";

    public void userControl() {
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithClassName(USER_LINK)));
        Assert.assertEquals(getTestDataPF("email"), methodes.WEwithId(USER_LINK).getText());

        System.out.println("Üye Girişi Başarıyla Yapıldı");
    }

    public void searchData(String searchData) {
        methodes.WEwithId(SEARCH_BOX).sendKeys(searchData);
        methodes.WEwithClassName(SEARCH_BUTTON).click();
        Assert.assertEquals(driver.getTitle(), searchData + " - n11.com");

        System.out.println(searchData + " Arama Sayfası Açıldı");

    }
}
