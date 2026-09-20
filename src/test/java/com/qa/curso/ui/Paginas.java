package com.qa.curso.ui;

import java.nio.file.Paths;

public class Paginas {

    public static String urlLogin() {
        return Paths.get("src", "test", "resources", "login.html").toUri().toString();
    }
}