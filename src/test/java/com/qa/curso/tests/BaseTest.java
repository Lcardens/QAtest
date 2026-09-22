package com.qa.curso.tests;

import com.qa.curso.driver.WebDriverFactory;
import com.qa.curso.ui.LoginPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage login;

    @BeforeEach
    void preparar() {
        driver = WebDriverFactory.crear();
        login = new LoginPage(driver);
    }

    @AfterEach
    void limpiar() {
        driver.quit();            
    }
}