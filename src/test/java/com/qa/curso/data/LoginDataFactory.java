package com.qa.curso.data;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class LoginDataFactory {
    public static Stream<Arguments>casosDeLogin(){
        return Stream.of(
                Arguments.of("admin", "1234", "Bienvenido admin"),
                Arguments.of("admin", "wrong", "Usuario o clave incorrectos"),
                Arguments.of("admin", "", "Usuario o clave incorrectos"),
                Arguments.of("", "1234", "Usuario o clave incorrectos"),
                Arguments.of("", "", "Usuario o clave incorrectos"),
                Arguments.of("pepe", "1234", "Usuario o clave incorrectos")
        );
    }
}
