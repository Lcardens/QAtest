package com.qa.curso.steps;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.curso.driver.WebDriverFactory;
import com.qa.curso.ui.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage login;

    @Given("the login page is open")
    public void theLoginPageIsOpen() {
        driver = WebDriverFactory.crear();
        login = new LoginPage(driver);
        login.abrir();
    }

    @When("I enter the user {string} and the password {string}")
    public void iEnterCredentials(String usuario, String clave) {
        login.escribirUsuario(usuario);
        login.escribirClave(clave);
        login.hacerClicEnIngresar();
    }

    @Then("I see the message {string}")
    public void iSeeTheMessage(String esperado) {
        String texto = esperado.startsWith("Bienvenido")
                ? login.textoBienvenida()
                : login.textoDeError();
        assertThat(texto).isEqualTo(esperado);
        driver.quit();
    }
}