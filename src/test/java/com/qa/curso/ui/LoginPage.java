package com.qa.curso.ui;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage { // cada LoginPage es una CAJA que guarda su propio volante (driver)
    private final WebDriver driver;

    // el molde necesita que le pasen el volante al construirlo
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void abrir() {
        driver.get(Paginas.urlLogin());
    }

    public void escribirUsuario(String usuario) {
        driver.findElement(By.id("usuario")).sendKeys(usuario);
    }

    public void escribirClave(String clave) {
        driver.findElement(By.id("clave")).sendKeys(clave);
    }

    public void hacerClicEnIngresar() {
        driver.findElement(By.id("btnIngresar")).click();
    }

    // una accion COMPUESTA: junta varios pasos
    public void iniciarSesion(String usuario, String clave) {
        abrir();
        escribirUsuario(usuario);
        escribirClave(clave);
        hacerClicEnIngresar();
    }

    public String textoBienvenida() {
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bienvenida = espera.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("bienvenida")));
        return bienvenida.getText();
    }

    public String textoDeError() {
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensaje = espera.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("mensaje")));
        return mensaje.getText();
    }
}

