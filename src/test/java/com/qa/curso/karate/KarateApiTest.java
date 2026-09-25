package com.qa.curso.karate;

import com.intuit.karate.junit5.Karate;

class KarateApiTest {

    @Karate.Test
    Karate probarLoginApi() {
        return Karate.run("classpath:com/qa/curso/karate/login-api.feature");
    }
}