package com.doublev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddAnotherTab {
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
    public void addAnotherTabletTest() {
        String search = "Samsung Galaxy Tab";
        String quantity ="2";
        WebElement searchBar = driver.findElement(By.xpath("//*[@id='search']/input"));
        searchBar.sendKeys(search);
        WebElement searchButton = driver.findElement(By.xpath("//*[@id='search']/span/button"));
        searchButton.click();
        WebElement addToCartButton = driver.findElement(By.xpath("//*[@id='content']/div[3]/div/div/div[2]/div[2]/button[1]"));
        addToCartButton.click();
        WebElement shoppingCartButton = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[4]/a"));
        shoppingCartButton.click();
        WebElement moreQuantityInput = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/input"));
        moreQuantityInput.clear();
        moreQuantityInput.sendKeys(quantity);
        WebElement updateQuantity = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[1]"));
        updateQuantity.click();
        waiter(2000);
    }

    public static void waiter(int pSeconds) {
        try {
            Thread.sleep(pSeconds);
        } catch (Exception e){
            System.out.println("Algo ocurrió");
        }
    }
}
