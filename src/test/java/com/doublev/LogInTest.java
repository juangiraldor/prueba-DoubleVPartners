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

public class LogInTest {
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
    public void loginTest() {
        String email = "esteban@mailprueba.com";
        String password = "password";
        WebElement myAccount = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a"));
        myAccount.click();
        WebElement login = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a"));
        login.click();
        WebElement emailAddress = driver.findElement(By.xpath("//*[@id='input-email']"));
        emailAddress.sendKeys(email);
        WebElement passwordField = driver.findElement(By.xpath("//*[@id='input-password']"));
        passwordField.sendKeys(password);
        WebElement loginButton = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/input"));
        loginButton.click();
        WebElement myAccountTitle = driver.findElement(By.xpath("//*[@id='content']/h2[1]"));
        if (myAccountTitle.isDisplayed()) {
            System.out.println("Inicio de sesión exitoso");
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
