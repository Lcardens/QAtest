package com.qa.curso.screenplay.tasks;

import static net.serenitybdd.screenplay.Tasks.instrumented;

import com.qa.curso.screenplay.ui.LoginTargets;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.annotations.Subject;

@Subject("Iniciar sesión con #usuario")
public class IniciarSesion implements Task {

    private final String usuario;
    private final String clave;

    public IniciarSesion(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }

    public static IniciarSesion con(String usuario, String clave) {
        return instrumented(IniciarSesion.class, usuario, clave);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(usuario).into(LoginTargets.CAMPO_USUARIO),
                Enter.theValue(clave).into(LoginTargets.CAMPO_CLAVE),
                Click.on(LoginTargets.BOTON_INGRESAR)
        );
    }
}
