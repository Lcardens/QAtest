package com.qa.curso.screenplay.questions;

import java.time.Duration;

import com.qa.curso.screenplay.ui.LoginTargets;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElMensaje implements Question<String> {

    public static Question<String> visible() {
        return new ElMensaje();
    }

    @Override
    public String answeredBy(Actor actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(d -> LoginTargets.MENSAJE_BIENVENIDA.resolveFor(actor).isVisible()
                        || LoginTargets.MENSAJE_ERROR.resolveFor(actor).isVisible());

        if (LoginTargets.MENSAJE_BIENVENIDA.resolveFor(actor).isVisible()) {
            return LoginTargets.MENSAJE_BIENVENIDA.resolveFor(actor).getText();
        }
        return LoginTargets.MENSAJE_ERROR.resolveFor(actor).getText();
    }
}