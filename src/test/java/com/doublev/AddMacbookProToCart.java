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

public class AddMacbookProToCart {
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
    public void addMacbookProTest() {
        WebElement laptopsAndNotebooks = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(laptopsAndNotebooks).perform();
        WebElement showAll = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a"));
        showAll.click();
        WebElement addToCartMacbook = driver.findElement(By.xpath("//*[@id='content']/div[4]/div[4]/div/div[2]/div[2]/button[1]"));
        addToCartMacbook.click();
        waiter(2000);
        WebElement previewCart = driver.findElement(By.xpath("//*[@id='cart']/button"));
        previewCart.click();
        WebElement productInTheCart = driver.findElement(By.xpath("//*[@id='cart']/ul/li[1]/table/tbody/tr/td[2]/a"));
        if (productInTheCart.isDisplayed()) {
            System.out.println("Se agregó correctamente el MacBook Pro");
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
