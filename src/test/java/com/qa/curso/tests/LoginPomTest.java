package com.qa.curso.tests;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class LoginPomTest extends BaseTest {

    @Test
    void unPacienteIniciaSesion() {
        login.iniciarSesion("admin", "1234");

        assertThat(login.textoBienvenida()).isEqualTo("Bienvenido admin");
    }

    @Test
    void usuarioConClaveIncorrectaVeError() {
        login.iniciarSesion("admin", "9999");

        assertThat(login.textoDeError()).isEqualTo("Usuario o clave incorrectos");
    }
}


