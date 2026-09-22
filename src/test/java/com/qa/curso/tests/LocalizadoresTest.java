package com.qa.curso.tests;
import static org.assertj.core.api.Assertions.assertThat;
import com.qa.curso.driver.WebDriverFactory;
import com.qa.curso.ui.Paginas;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class LocalizadoresTest {
    @Test
    void porName(){
        WebDriver driver = WebDriverFactory.crear();
        driver.get(Paginas.urlLogin());

        WebElement campo = driver.findElement(By.name("usuario"));
        campo.sendKeys("ana");

        assertThat(campo.getAttribute("value")).isEqualTo("ana");

        driver.quit();

    }

    @Test
    void porCssSelector(){
        WebDriver driver = WebDriverFactory.crear();
        driver.get(Paginas.urlLogin());

        WebElement clave = driver.findElement(By.cssSelector("input[type='password']"));
        clave.sendKeys("1234");

        assertThat(clave.getAttribute("value")).isEqualTo("1234");

        driver.quit();

    }
    @Test
    void porXpath() {
        WebDriver driver = WebDriverFactory.crear();
        driver.get(Paginas.urlLogin());

        WebElement boton = driver.findElement(By.xpath("//button[text()='Ingresar']"));
        boton.click();

        assertThat(driver.findElement(By.id("mensaje")).isDisplayed()).isTrue();

        driver.quit();
    }

    @Test
    void porTagNameYfindElements() {
        WebDriver driver = WebDriverFactory.crear();
        driver.get(Paginas.urlLogin());

        List<WebElement> divsAviso = driver.findElements(By.className("aviso"));
        assertThat(divsAviso).hasSize(2);
        List<WebElement> inputs = driver.findElements(By.tagName("input"));
        assertThat(inputs).hasSize(2);

        driver.quit();
    }
}


