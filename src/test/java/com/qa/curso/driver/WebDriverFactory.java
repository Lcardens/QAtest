package com.qa.curso.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverFactory {

    public static WebDriver crear() {
        String navegador = System.getProperty("browser", "chrome");
        if ("edge".equalsIgnoreCase(navegador)) {
            return new EdgeDriver();
        }

        ChromeOptions opciones = new ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "false"))) {
            opciones.addArguments("--headless=new");
            opciones.addArguments("--no-sandbox");
            opciones.addArguments("--disable-dev-shm-usage");
        }
        return new ChromeDriver(opciones);
    }
}