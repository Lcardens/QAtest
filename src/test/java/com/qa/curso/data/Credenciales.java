package com.qa.curso.data;

public final class Credenciales {

    private Credenciales() {
    }

    public static String usuarioAdmin() {
        return leer("USUARIO_ADMIN", "usuario.admin");
    }

    public static String claveAdmin() {
        return leer("CLAVE_ADMIN", "clave.admin");
    }

    private static String leer(String env, String propiedad) {
        String valor = System.getenv(env);
        if (valor == null || valor.isBlank()) {
            valor = System.getProperty(propiedad);
        }
        if (valor == null || valor.isBlank()) {
            throw new IllegalStateException(
                    "Falta la credencial: variable de entorno '" + env
                            + "' o propiedad '-D" + propiedad + "'. Configurala en tu maquina o en los Secrets del CI.");
        }
        return valor;
    }
}