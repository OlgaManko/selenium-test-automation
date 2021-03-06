package com.testinium.page;

import com.testinium.methods.Methods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class CatalogPage {

    Methods methods;
    Random rand = new Random();

    public CatalogPage() {

        methods = new Methods();

    }

    public void selectRandomBook() {

        methods.click(By.cssSelector("img[title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(2);
        methods.selectByText(By.cssSelector("div[class='sort']>select[onchange='location = this.value;'"), "Yüksek Oylama");
        methods.waitBySeconds(2);
        methods.click(By.xpath("//li/span[text()='Tüm Kitaplar']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("li>a[href='kategori/kitap-hobi/1_212.html']"));
        methods.waitBySeconds(2);

        // Sayfadaki random item sepete atılır.
        selectRandomProduct();
        methods.waitBySeconds(2);
        methods.click(By.xpath("//span[text()='Sepete Ekle']"));

        // Listelerim > Favorilerim sayfasına gidilir.
        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//a[text()='Favorilerim']"));
        methods.waitBySeconds(2);

        // Sepetim sayfasına gidilir. Ürün adedi arttırılıp satın al butonuna tıklanır.
        methods.click(By.cssSelector("#cart > div.heading"));
        methods.waitBySeconds(2);
        methods.click(By.id("js-cart"));
        methods.findElement(By.xpath("//input[@name='quantity']")).clear();
        methods.waitBySeconds(1);
        methods.sendKeys(By.xpath("//input[@name='quantity']"),"4");
        methods.waitBySeconds(1);
        methods.click(By.xpath("//i[@title='Güncelle']"));
        methods.waitBySeconds(2);
        methods.click(By.cssSelector("div[class='right']>a[class='button red']"));
        methods.waitBySeconds(2);

        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(2);

        methods.click(By.cssSelector("button[id='button-checkout-continue']"));
        methods.waitBySeconds(10);
        methods.click(By.cssSelector("button[id='button-checkout-continue']"));
        methods.waitBySeconds(3);
        methods.sendKeys(By.cssSelector("input[id='credit-card-owner']"), "Duru Altay");
        methods.waitBySeconds(3);
        methods.sendKeys(By.cssSelector("input[id='credit_card_number_1']"), "1234123412341234");
        methods.waitBySeconds(3);
        methods.selectByText(By.cssSelector("select[id='credit-card-expire-date-month']"),"02");
        methods.waitBySeconds(3);
        methods.selectByText(By.cssSelector("select[id='credit-card-expire-date-year']"),"2024");
        methods.waitBySeconds(3);
        methods.sendKeys(By.cssSelector("input[id='credit-card-security-code']"), "123");
        methods.waitBySeconds(3);
        methods.click(By.cssSelector("label[id='credit-card-is-3ds-label']"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector("label[id='register-credit-card-label']"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector("button[id='button-checkout-continue']"));
        methods.waitBySeconds(3);
        String text = methods.getText(By.cssSelector("span[class='error']"));

        methods.click(By.cssSelector("#logo > a > img"));
        methods.waitBySeconds(3);
        methods.scrollWithAction(By.cssSelector("#header-top > div > div.welcome.fl > div.menu.top.login > ul > li > a"));
        methods.click(By.cssSelector("#header-top > div > div.welcome.fl > div.menu.top.login > ul > li > div > ul > li:nth-child(4) > a"));


    }

    public void selectRandomProduct() {
        List<WebElement> productList = methods.findElements(By.cssSelector(".pr-img-link"));
        // List<WebElement> productList = methods.findAllElements(By.cssSelector(".add-to-cart"));
        int randNum = rand.nextInt(productList.size()); //0 - productList.size()
        productList.get(randNum).click();
    }

}


