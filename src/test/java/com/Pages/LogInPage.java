package com.Pages;


import com.Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Reporter;

import java.util.Spliterator;

public class LogInPage extends BaseTest {
    //Datos
    String email = "esteban@mailprueba.com";
    String password = "password";

    //Localizadores
    private static final By myAccount = By.xpath("//*[@id='top-links']/ul/li[2]/a");
    private static final By login = By.xpath("//*[@id='top-links']/ul/li[2]/ul/li[2]/a");
    private static final By emailAddress = By.xpath("//*[@id='input-email']");
    private static final By passwordField = By.xpath("//*[@id='input-password']");
    private static final By loginButtton = By.xpath("//*[@id='content']/div/div[2]/div/form/input");
    private static final By myAccountTitle = By.xpath("//*[@id='content']/h2[1]");

    //Métodos de acción
    public static void clickMyAccount(){driver.findElement(myAccount);}
    public static void clickLogin(){driver.findElement(login);}

    public static void loginUser(){
        System.out.println("Damos click en MyAccount");
        Reporter.log("Se dio click en MyAccount");
        driver.findElement(myAccount).click();
        System.out.println("Damos click en Login");
        driver.findElement(login).click();
        System.out.println("Se valida que el formulario exista en el DOM");
        softAssertl.assertTrue(driver.findElement(emailAddress).isDisplayed());
        softAssertl.assertTrue(driver.findElement(passwordField).isDisplayed());
        softAssertl.assertAll();

        System.out.println("Ingresamos las credenciales de logueo");
        driver.findElement(emailAddress).sendKeys("esteban@mailprueba.com");
        driver.findElement(passwordField).sendKeys("password");

        System.out.println("Iniciamos sesión");
        driver.findElement(loginButtton).click();

    }


}
