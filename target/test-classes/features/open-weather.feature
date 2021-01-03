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