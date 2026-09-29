package com.qa.curso.steps;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import net.serenitybdd.core.Serenity;

import com.qa.curso.driver.WebDriverFactory;
import com.qa.curso.screenplay.questions.ElMensaje;
import com.qa.curso.screenplay.tasks.IniciarSesion;
import com.qa.curso.ui.Paginas;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;

import org.openqa.selenium.WebDriver;

public class LoginSteps {

    private WebDriver driver;
    private Actor luisa;

    @Given("the login page is open")
    public void theLoginPageIsOpen() {
        driver = WebDriverFactory.crear();
        Serenity.useDriver(driver);                      // <-- nueva: se lo damos a Serenity
        luisa = Actor.named("Luisa").whoCan(BrowseTheWeb.with(driver));
        luisa.wasAbleTo(Open.url(Paginas.urlLogin()));
    }
    @When("I enter the user {string} and the password {string}")
    public void iEnterCredentials(String usuario, String clave) {
        luisa.attemptsTo(IniciarSesion.con(usuario, clave));
    }

    @Then("I see the message {string}")
    public void iSeeTheMessage(String esperado) {
        luisa.should(seeThat(ElMensaje.visible(), equalTo(esperado)));
    }

    @After
    public void cerrarNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}