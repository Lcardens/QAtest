package com.qa.curso.ui;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);   //  el "repartidor"
    }

    @FindBy(id = "usuario")
    private WebElement campoUsuario;              // cajita etiquetada

    @FindBy(id = "clave")
    private WebElement campoClave;

    @FindBy(id = "btnIngresar")
    private WebElement botonIngresar;

    @FindBy(id = "bienvenida")
    private WebElement mensajeBienvenida;

    @FindBy(id = "mensaje")
    private WebElement mensajeError;

    public void abrir() {
        driver.get(Paginas.urlLogin());
    }

    public void escribirUsuario(String usuario) {
        campoUsuario.sendKeys(usuario);           // uso la cajita
    }

    public void escribirClave(String clave) {
        campoClave.sendKeys(clave);
    }

    public void hacerClicEnIngresar() {
        botonIngresar.click();
    }

    public void iniciarSesion(String usuario, String clave) {
        abrir();
        escribirUsuario(usuario);
        escribirClave(clave);
        hacerClicEnIngresar();
    }

    public String textoBienvenida() {
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.visibilityOf(mensajeBienvenida));
        return mensajeBienvenida.getText();
    }

    public String textoDeError() {
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        espera.until(ExpectedConditions.visibilityOf(mensajeError));
        return mensajeError.getText();
    }
}