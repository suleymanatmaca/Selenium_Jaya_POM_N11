package com.n11.pages;

import junit.framework.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FavPage extends ProductPage {
    private static final String FAV_LINK = "(//*[@class='listItemTitle'])[1]";
    public static final String PRODUCT_ID_LIST = "//*[@id='view']/ul/li[3]/div/div/a";


    public void controlFavPage() {
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithClassName(FAV_LINK)));
        Assert.assertEquals(methodes.WEwithXpath(FAV_LINK).isDisplayed(), true);
        methodes.WEwithXpath(FAV_LINK).click();

        System.out.println("Favori listesi sayfasındayım");
    }

    public void confirmSelectedProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(methodes.WEwithClassName(SELECT_PRODUCT_ID)));

        Assert.assertTrue(methodes.isProductDisplay(selectedProductId));

    }

    public void deleteProduct() {
        methodes.WEwithCss("#p-" + selectedProductId + " .deleteProFromFavorites").click();
        System.out.println("Sil butonuna tıklandı");

    }

    public void confirmDeletedProduct() {
        Assert.assertFalse(methodes.isProductDisplay(selectedProductId));
    }

}
