package com.qa.curso.tests;

import static org.assertj.core.api.Assertions.assertThat;

import com.qa.curso.data.Credenciales;
import org.junit.jupiter.api.Test;

public class LoginPomTest extends BaseTest {

    @Test
    void unPacienteIniciaSesion() {
        login.iniciarSesion(Credenciales.usuarioAdmin(), Credenciales.claveAdmin());

        assertThat(login.textoBienvenida()).isEqualTo("Bienvenido admin");
    }

    @Test
    void usuarioConClaveIncorrectaVeError() {
        login.iniciarSesion("admin", "9999");

        assertThat(login.textoDeError()).isEqualTo("Usuario o clave incorrectos");
    }
}


