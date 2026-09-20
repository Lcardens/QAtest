package com.qa.curso.tests;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import com.qa.curso.driver.WebDriverFactory;
import com.qa.curso.ui.Paginas;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * TU PRIMER TEST. Selenium puro, todo comentado.
 * Los 5 pasos de TODA prueba de UI: abrir -> actuar -> esperar -> verificar -> cerrar.
 */
public class MiPrimerTest {

    @Test
    void unPacienteIniciaSesion() {
        // 1) ABRIR: fabrico el volante de Chrome (WebDriverFactory hace el `new`)
        WebDriver driver = WebDriverFactory.crear();

        // 2) ACTUAR:
        driver.get(Paginas.urlLogin());                    // abrir la pagina de login
        driver.findElement(By.id("usuario")).sendKeys("admin"); // encontrar campo y escribir
        driver.findElement(By.id("clave")).sendKeys("1234");    // escribir la clave
        driver.findElement(By.id("btnIngresar")).click();       // clic en Ingresar

        // 3) ESPERAR: el mensaje de bienvenida debe hacerse visible (max 10s)
        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement bienvenida = espera.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("bienvenida")));

        // 4) VERIFICAR: compruebo el texto
        assertThat(bienvenida.getText()).isEqualTo("Bienvenido admin");

        // 5) CERRAR: apago Chrome
        driver.quit();
    }

    @Test
    void usuarioConClaveIncorrectaVeError() {
        // TERMINAMOS la espera hacia el MENSAJE DE ERROR (no hacia la bienvenida)
        WebDriver driver = WebDriverFactory.crear();

        driver.get(Paginas.urlLogin());
        driver.findElement(By.id("usuario")).sendKeys("admin");
        driver.findElement(By.id("clave")).sendKeys("9999");   // clave MALA
        driver.findElement(By.id("btnIngresar")).click();

        WebDriverWait espera = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement mensaje = espera.until(
                ExpectedConditions.visibilityOfElementLocated(By.id("mensaje")));

        assertThat(mensaje.getText()).isEqualTo("Usuario o clave incorrectos");

        driver.quit();
    }
}