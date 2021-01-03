#language: pt
#encoding: UTF-8
#Author: Victor Neves

  Funcionalidade: Clima atual

    Contexto:
      Dado que eu informe a chave de api "cc7d547753a20fb8fd136a18c5e22eff"

    @weatherByCityName
    Cenario: Buscar clima atual pelo nome da cidade
      E que eu informe a cidade "Itaquera" para pesquisa de clima
      Quando realizar uma requisição "GET" na url "https://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}"
      Então devo receber o status "200"
      E devo receber a chave "name" com o valor "Itaquera" no retorno do serviço

    @weatherByCityID
    Cenario: Buscar clima atual pela ID da cidade
      E que eu informe a id da cidade "3448433" para pesquisa de clima
      Quando realizar uma requisição "GET" na url "https://api.openweathermap.org/data/2.5/weather?id={id}&appid={appid}"
      Então devo receber o status "200"
      E devo receber a chave "name" com o valor "São Paulo" no retorno do serviço

    @weatherByGeographicCoordinates
    Cenario: Buscar clima atual pelas coordenadas geográficas
      E que eu informe a latitude "35" e a longitude "139" da cidade para pesquisa de clima
      Quando realizar uma requisição "GET" na url "https://api.openweathermap.org/data/2.5/weather?lat={lat}&lon={lon}&appid={appid}"
      Então devo receber o status "200"
      E devo receber a chave "name" com o valor "Shuzenji" no retorno do serviço

    @weatherByZipCode
    Cenario: Buscar clima atual por zipcode
      E que eu informe o zipcode "72716" da cidade para pesquisa de clima
      Quando realizar uma requisição "GET" na url "https://api.openweathermap.org/data/2.5/weather?zip={zip}&appid={appid}"
      Então devo receber o status "200"
      E devo receber a chave "name" com o valor "Bentonville" no retorno do serviço

    @weatherByRectangleZone
    Cenario: Buscar climas dentro de uma area retangular
      E que eu informe a longitude esquerda "12", a latitude inferior "32", a longitude direita "15", a latitude superior "37" e o zoom "10" do retangulo para pesquisa de clima
      Quando realizar uma requisição "GET" na url "https://api.openweathermap.org/data/2.5/box/city?bbox={lon-left},{lat-bottom},{lon-right},{lat-top},{zoom}&appid={appid}"
      Então devo receber o status "200"
      E devo receber a chave "list" no retorno do serviço

      