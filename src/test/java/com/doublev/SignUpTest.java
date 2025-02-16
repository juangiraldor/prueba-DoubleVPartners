package com.doublev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest {

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
    public void signUpTest() {
        String firstName = "Esteban";
        String lastName = "Giraldo";
        String email = "esteban@mailprueba.com";
        String telephone = "3125689745";
        String password = "password";
        WebElement myAccount = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/a"));
        myAccount.click();
        waiter(2000);
        WebElement register = driver.findElement(By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[1]/a"));
        register.click();
        waiter(2000);
        WebElement firstNameInput = driver.findElement(By.xpath("//*[@id='input-firstname']"));
        firstNameInput.sendKeys(firstName);
        WebElement lastNameInput = driver.findElement(By.xpath("//*[@id='input-lastname']"));
        lastNameInput.sendKeys(lastName);
        WebElement emailInput = driver.findElement(By.xpath("//*[@id='input-email']"));
        emailInput.sendKeys(email);
        WebElement telephoneInput = driver.findElement(By.xpath("//*[@id='input-telephone']"));
        telephoneInput.sendKeys(telephone);
        WebElement passwordInput = driver.findElement(By.xpath("//*[@id='input-password']"));
        passwordInput.sendKeys(password);
        WebElement passwordConfirm = driver.findElement(By.xpath("//*[@id='input-confirm']"));
        passwordConfirm.sendKeys(password);
        WebElement subscribeButton = driver.findElement(By.xpath("//*[@id='content']/form/fieldset[3]/div/div/label[1]/input"));
        subscribeButton.click();
        WebElement agreeButton = driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[1]"));
        agreeButton.click();
        WebElement continueButton = driver.findElement(By.xpath("//*[@id='content']/form/div/div/input[2]"));
        continueButton.click();
        WebElement confirmationText = driver.findElement(By.xpath("//*[@id='content']/p[1]"));
        if (confirmationText.isDisplayed()) {
            System.out.println("La prueba se completó con exito");
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
