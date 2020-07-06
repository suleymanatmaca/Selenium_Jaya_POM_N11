package com.n11.tests;

import com.n11.steps.n11Steps;
import com.n11.utils.Initialize;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners()
public class RunTest extends Initialize {

    n11Steps user = new n11Steps();

    @Test
    public void runTest() {
        user.openBrowser();
        user.navigateToLoginPage();
        user.setUserInfoAndClick();
        user.setSearch(getTestDataPF("searchData"));
        user.confirmProduct();
        user.navigateAndConfirmPage(getTestDataPF("page"));
        user.selectProduct();
        user.confirmProductOnFavList();
        user.deleteProductOnFavListAndConfirm();
    }
}
