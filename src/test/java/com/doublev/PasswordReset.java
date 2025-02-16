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

public class PasswordReset {
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
    public void passwordResetTest() {
        String email = "esteban@mailprueba.com";
        WebElement myAccount = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a"));
        myAccount.click();
        WebElement login = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a"));
        login.click();
        WebElement forgottenPassword = driver.findElement(By.xpath("//*[@id='content']/div/div[2]/div/form/div[2]/a"));
        forgottenPassword.click();
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='input-email']"));
        emailInput.sendKeys(email);
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='content']/form/div/div[2]/input"));
        continueButton.click();
        WebElement emailSentConfirmation = driver.findElement(By.xpath("//*[@id='account-login']/div[1]"));
        if (emailSentConfirmation.isDisplayed()) {
            System.out.println("Se envió correctamente el mensaje");
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
