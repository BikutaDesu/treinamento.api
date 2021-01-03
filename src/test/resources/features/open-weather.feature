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

      