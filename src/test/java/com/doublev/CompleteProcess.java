package com.doublev;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompleteProcess {
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
    public void completeProcessTest() {
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
        WebElement laptopsAndNotebooks = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/a"));
        Actions action = new Actions(driver);
        action.moveToElement(laptopsAndNotebooks).perform();
        WebElement showAll = driver.findElement(By.xpath("//*[@id='menu']/div[2]/ul/li[2]/div/a"));
        showAll.click();
        WebElement addToCartMacbook = driver.findElement(By.xpath("//*[@id='content']/div[4]/div[4]/div/div[2]/div[2]/button[1]"));
        addToCartMacbook.click();
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
        WebElement moreQuantityInput = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr[2]/td[4]/div/input"));
        moreQuantityInput.clear();
        moreQuantityInput.sendKeys(quantity);
        WebElement updateQuantity = driver.findElement(By.xpath("//*[@id='content']/form/div/table/tbody/tr/td[4]/div/span/button[1]"));
        updateQuantity.click();
        WebElement continueCheckout = driver.findElement(By.xpath("//*[@id='content']/div[3]/div[2]/a"));
        continueCheckout.click();
        waiter(2000);
        WebElement billingDetailsButton = driver.findElement(By.xpath("//*[@id='button-payment-address']"));
        billingDetailsButton.click();
        waiter(2000);
        WebElement deliveryDetailsButton = driver.findElement(By.xpath("//*[@id='button-shipping-address']"));
        deliveryDetailsButton.click();
        waiter(2000);
        WebElement deliveryMethodButton = driver.findElement(By.xpath("//*[@id='button-shipping-method']"));
        deliveryMethodButton.click();
        waiter(2000);
        WebElement cashButton = driver.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[2]/label/input"));
        cashButton.click();
        waiter(2000);
        WebElement acceptTermsButton = driver.findElement(By.xpath("//*[@id='collapse-payment-method']/div/div[3]/div/input[1]"));
        acceptTermsButton.click();
        WebElement continuePaymentMethod = driver.findElement(By.xpath("//*[@id='button-payment-method']"));
        continuePaymentMethod.click();
        waiter(10000);
        WebElement confirmOrderButton = driver.findElement(By.xpath("//*[@id='button-confirm']"));
        confirmOrderButton.click();
        waiter(2000);
        WebElement orderConfirmed = driver.findElement(By.xpath("//*[@id='content']/h1"));
        if (orderConfirmed.isDisplayed()) {
            System.out.println("La orden se completó correctamente");
        }
        waiter(4000);

    }

    public static void waiter(int pSeconds) {
        try {
            Thread.sleep(pSeconds);
        } catch (Exception e){
            System.out.println("Algo ocurrió");
        }
    }
}
