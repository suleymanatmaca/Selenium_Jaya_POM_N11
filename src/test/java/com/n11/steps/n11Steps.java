package com.n11.steps;

import com.n11.pages.*;

public class n11Steps {

    BasePage basePage = new BasePage();
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    ProductPage productPage = new ProductPage();
    FavPage favPage = new FavPage();


    public void navigateToLoginPage() {
        basePage.closePopUp();

        basePage.navigateToSignOnPage();
    }

    public void openBrowser() {
        basePage.webPageOpen();
    }

    public void setUserInfoAndClick() {
        loginPage.setLoginInfo();
        loginPage.clickLoginButton();
    }

    public void setSearch(String search) {
        mainPage.userControl();
        mainPage.searchData(search);
    }

    public void confirmProduct() {
        productPage.productControl();
    }

    public void navigateAndConfirmPage(String page) {
        productPage.navigatePage(page);
        productPage.confirmPage(page);
    }

    public void selectProduct() {
        productPage.selectProduct();
        productPage.checkSelectedFav();
        productPage.navigateToFavList();
    }

    public void confirmProductOnFavList() {
        favPage.controlFavPage();
        favPage.confirmSelectedProduct();
    }

    public void deleteProductOnFavListAndConfirm() {
        favPage.deleteProduct();
        favPage.confirmDeletedProduct();
    }
}
