package com.qa.curso.screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginTargets {

    public static final Target CAMPO_USUARIO = Target.the("cajita de usuario")
            .located(By.name("usuario"));

    public static final Target CAMPO_CLAVE = Target.the("cajita de la contraseña")
            .located(By.cssSelector("input[type='password']"));

    public static final Target BOTON_INGRESAR = Target.the("botón Ingresar")
            .located(By.id("btnIngresar"));

    public static final Target MENSAJE_BIENVENIDA = Target.the("mensaje de bienvenida")
            .located(By.id("bienvenida"));

    public static final Target MENSAJE_ERROR = Target.the("mensaje de error")
            .located(By.id("mensaje"));
}