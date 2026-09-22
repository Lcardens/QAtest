package com.qa.curso.tests;

import static com.qa.curso.data.LoginDataFactory.casosDeLogin;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class LoginParametrizadoTest extends BaseTest {

    @ParameterizedTest(name = "[{index}] usuario=''{0}'' clave=''{1}'' -> {2}")
    @MethodSource("com.qa.curso.data.LoginDataFactory#casosDeLogin")
    void verificarLogin(String usuario, String clave, String textoEsperado) {
        login.iniciarSesion(usuario, clave);

        String texto = textoEsperado.startsWith("Bienvenido")
                ? login.textoBienvenida()
                : login.textoDeError();

        assertThat(texto).isEqualTo(textoEsperado);
    }
}