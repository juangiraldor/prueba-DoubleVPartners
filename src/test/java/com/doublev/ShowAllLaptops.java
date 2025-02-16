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

public class ShowAllLaptops {
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
    public void showLaptopsTest() {
        WebElement laptopsAndNotebooks = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(laptopsAndNotebooks).perform();
        WebElement showAll = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a"));
        showAll.click();
        WebElement laptopsAndNotebooksTitle = driver.findElement(By.xpath("//*[@id='content']/h2"));
        if (laptopsAndNotebooksTitle.isDisplayed()) {
            System.out.println("Se ingresó correctamente a la sección de Notebooks y Laptops");
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
