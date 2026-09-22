package com.qa.curso.tests;

import static org.assertj.core.api.Assertions.assertThat;
import com.qa.curso.driver.WebDriverFactory;
import com.qa.curso.ui.LoginPage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.WebDriver;

public class LoginParametrizadoTest {

    @ParameterizedTest(name = "[{index}] usuario=''{0}'' clave=''{1}'' -> {2}")
    @MethodSource("com.qa.curso.data.LoginDataFactory#casosDeLogin")
    void verificarLogin(String usuario, String clave, String textoEsperado) {
        WebDriver driver = WebDriverFactory.crear();
        LoginPage login = new LoginPage(driver);

        login.iniciarSesion(usuario, clave);

        String texto = textoEsperado.startsWith("Bienvenido")
                ? login.textoBienvenida()   // si esperamos bienvenida
                : login.textoDeError();     // si esperamos error

        assertThat(texto).isEqualTo(textoEsperado);

        driver.quit();
    }
}