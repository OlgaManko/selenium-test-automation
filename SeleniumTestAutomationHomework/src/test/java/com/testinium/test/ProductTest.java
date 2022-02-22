package com.testinium.test;

import com.testinium.driver.BaseTest;
import com.testinium.page.CatalogPage;
import com.testinium.page.HomePage;
import com.testinium.page.LoginPage;
import com.testinium.page.ProductPage;
import org.junit.Test;

public class ProductTest extends BaseTest {

    @Test
    public void productTest() {

        LoginPage loginPage = new LoginPage();
        ProductPage productPage = new ProductPage();
        HomePage homePage = new HomePage();
        CatalogPage catalogPage = new CatalogPage();

        loginPage.login();
        productPage.selectFavorites();
        homePage.openHomePage();
        catalogPage.selectRandomBook();

    }


}
