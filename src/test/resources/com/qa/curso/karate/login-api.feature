Feature: Login en la API publica Reqres

  Scenario: Login exitoso devuelve un token
    Given url 'https://reqres.in/api/login'
    And request { email: 'eve.holt@reqres.in', password: 'cityslicka' }
    When method Post
    Then status 200
    And match response.token == '#notnull'

  Scenario: Login con clave vacia falla
    Given url 'https://reqres.in/api/login'
    And request { email: 'peter@klaven', password: '' }
    When method Post
    Then status 400
    And match response.error == 'Missing password'

  Scenario: Crear un usuario
    Given url 'https://reqres.in/api/users'
    And request { name: 'Luisa', job: 'QA'}
    When method Post
    Then status 201
    And match response.id == '#notnull'