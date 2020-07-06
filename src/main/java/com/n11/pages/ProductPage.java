package com.n11.pages;

import com.n11.utils.Initialize;
import junit.framework.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends Initialize {
    private static final String PRODUCT = "//*[@id=\"view\"]/ul/li[@class=\"column \"]";
    private static final String SELECT_PRODUCT = "//div[@id=\"view\"]/ul/li[3]";
    private static final String SELECT_PRODUCT_FAV_BUTTON = "//div[@id=\"view\"]/ul/li[3]//span[@class=\"textImg followBtn\"]";
    private static final String SELECT_PRODUCT_NAME = "//div[@id=\"view\"]/ul/li[3]//h3[@class=\"productName bold\"]";
    protected static final String SELECT_PRODUCT_ID= "(//*[@id='view']/ul/li[3]/div/div/a)[1]";
    private static final String ADDED_FAV_PRODUCT = "textImg followBtn ok";
    private static final String MY_ACCOUNT = "myAccount";
    private static final String FAV_AND_LIST_LINK = "//*[@class='myAccountMenu hOpenMenu']/div[1]/a[2]";

    protected String selectedProductName = "";
    protected String selectedProductId = "";

    public void productControl() {
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithClassName(PRODUCT)));

        Assert.assertEquals(methodes.WEwithXpath(PRODUCT).isDisplayed(), true);

        System.out.println("Ürünler sayfasında ürün bulunmaktadır");
    }

    public void navigatePage(String page) {
        methodes.WEwithXpath("//*[@class='pagination']/a[" + page + "]").click();
    }

    public void confirmPage(String page) {

        Assert.assertEquals(driver.getCurrentUrl().contains("pg=" + page), true);
        System.out.println("Samsung Arama " + page + ".Sayfası Açıldı");
    }

    public void selectProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithClassName(SELECT_PRODUCT)));
        methodes.WEwithXpath(SELECT_PRODUCT_FAV_BUTTON).click();
        selectedProductId = methodes.WEwithXpath(SELECT_PRODUCT_ID).getAttribute("data-id");
        selectedProductName = methodes.WEwithXpath(SELECT_PRODUCT_NAME).getText();
        System.out.println("Seçilen Ürün - " + selectedProductName);
    }

    public void checkSelectedFav() {
        Assert.assertEquals(methodes.WEwithClassName(ADDED_FAV_PRODUCT).isDisplayed(), true);

        System.out.println("Seçilen Ürün Favorilere Eklendi");
    }

    public void navigateToFavList() {
        Actions action = new Actions(driver);
        action.moveToElement(methodes.WEwithClassName(MY_ACCOUNT)).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithClassName(FAV_AND_LIST_LINK)));
        methodes.WEwithClassName(FAV_AND_LIST_LINK).click();

        System.out.println("Favorilerim Listesine Yönlendirildi");
    }
}
