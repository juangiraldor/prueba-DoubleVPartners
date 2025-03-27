package com.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTest {
    protected static SoftAssert softAssertl;
    protected static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void masterSetUp(){
        softAssertl = new SoftAssert();
        System.out.println("Inicializamos el WebDriver");
        DesiredCapabilities ssl = DesiredCapabilities.chrome ();
        ssl.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        driver = new ChromeDriver(ssl);
        System.out.print("Ingresamos la URL:");
        driver.get("http://opencart.abstracta.us");
        System.out.println("Maximizamos la pantalla");
        driver.manage().window().maximize();
        System.out.println("Borramos cookies");
        driver.manage().deleteAllCookies();
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        System.out.println("Asignamos el webdriver");
        //new WebDriverProvider().set.(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void mastertearDown() {
        System.out.println("Finalizamos el Driver");
        driver.quit();
    }


}
