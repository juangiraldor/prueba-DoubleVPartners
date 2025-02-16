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

public class FindSamsungTablet {
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
    public void findSamsungTabletTest() {
        String search = "Samsung Galaxy Tab";
        WebElement searchBar = driver.findElement(By.xpath("//*[@id='search']/input"));
        searchBar.sendKeys(search);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='search']/span/button"));
        searchButton.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[1]"));
        addToCartButton.click();
        WebElement previewCart = driver.findElement(By.xpath("//*[@id='cart']/button"));
        previewCart.click();
        WebElement tabOnCart = driver.findElement(By.xpath("//<a>[text()=’Samsung Galaxy Tab 10.1’]"));
        if (tabOnCart.isDisplayed()) {
            System.out.println("La tablet se agregó correctamente al carrito");
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
