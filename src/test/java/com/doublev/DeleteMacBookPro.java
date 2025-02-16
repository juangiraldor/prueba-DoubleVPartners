package com.doublev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteMacBookPro {
    WebDriver driver;

    @BeforeMethod
    public void initializeTest() {
        System.setProperty("chrome.driver.webdriver" , "chromedriver.exe");
        DesiredCapabilities ssl = DesiredCapabilities.chrome ();
        ssl.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(ssl);
        driver.get("http://opencart.abstracta.us");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void finishTest() {
        driver.close();
    }

    @Test
    public void deleteMacBookTest() {
        WebElement laptopsAndNotebooks = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(laptopsAndNotebooks).perform();
        WebElement showAll = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a"));
        showAll.click();
        WebElement addToCartMacbook = driver.findElement(By.xpath("//*[@id='content']/div[4]/div[4]/div/div[2]/div[2]/button[1]"));
        addToCartMacbook.click();
        WebElement shoppingCartButton = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a"));
        shoppingCartButton.click();
        WebElement deleteMacBookProButton = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr[1]/td[4]/div/span/button[2]"));
        deleteMacBookProButton.click();
        WebElement macBookProduct = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr[1]/td[2]/a"));
        if (!macBookProduct.isDisplayed()) {
            System.out.println("Se eliminó el macbook correctamente");
        }
    }

    public static void waiter(int pSeconds) {
        try {
            Thread.sleep(pSeconds);
        } catch (Exception e){
            System.out.println("Algo ocurrió");
        }
    }
}
