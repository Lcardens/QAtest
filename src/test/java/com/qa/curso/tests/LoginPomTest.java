package com.qa.curso.tests;

import com.qa.curso.driver.WebDriverFactory;
import com.qa.curso.ui.LoginPage;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class LoginPomTest {
    @Test
    void unPacienteIniciaSesion(){
        WebDriver driver = WebDriverFactory.crear();
        LoginPage login = new LoginPage(driver);
        login.iniciarSesion("admin", "1234");
        assertThat(login.textoBienvenida()).isEqualTo("Bienvenido admin");
        driver.quit();
    }

    @Test
    void usuarioConClaveIncorrectaVeError(){
        WebDriver driver = WebDriverFactory.crear();
        LoginPage login = new LoginPage(driver);
        login.iniciarSesion("admin", "12434");
        assertThat(login.textoDeError())
                .isEqualTo("Usuario o clave incorrectos");
        driver.quit();
    }

    @Test
    void usuarioEquivocadoConClaveCorrectaVeError() {
        WebDriver driver = WebDriverFactory.crear();
        LoginPage login = new LoginPage(driver);
        login.iniciarSesion("pedro", "1234");
        assertThat(login.textoDeError())
                .isEqualTo("Usuario o clave incorrectos");
        driver.quit();
    }

    @Test
    void usuarioYClaveEquivocadosVeError() {
        WebDriver driver = WebDriverFactory.crear();
        LoginPage login = new LoginPage(driver);
        login.iniciarSesion("pedro", "9999");
        assertThat(login.textoDeError())
                .isEqualTo("Usuario o clave incorrectos");
        driver.quit();
    }

    @Test
    void usuarioVacioNoIniciaSesion() {
        WebDriver driver = WebDriverFactory.crear();
        LoginPage login = new LoginPage(driver);
        login.iniciarSesion("", "1234");
        assertThat(login.textoDeError())
                .isEqualTo("Usuario o clave incorrectos");
        driver.quit();
    }

    @Test
    void claveVaciaNoIniciaSesion() {
        WebDriver driver = WebDriverFactory.crear();
        LoginPage login = new LoginPage(driver);
        login.iniciarSesion("admin", "");
        assertThat(login.textoDeError())
                .isEqualTo("Usuario o clave incorrectos");
        driver.quit();
    }

}



