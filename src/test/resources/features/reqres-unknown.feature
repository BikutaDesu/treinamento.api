#language: pt
#encoding: UTF-8
#Author: Victor Neves

Funcionalidade: Endpoint unknown

  @getUsersByUnknown
  Cenario: pegar pagina da lista de usuários
    Dado que eu escolha a página "1" para pesquisa
    Quando realizar uma requisição "GET" na url "https://reqres.in/api/unknown?page={page}"
    Então devo receber o status "200"
    E devo receber a chave "data" no retorno do serviço

  @getUserByUnknown
  Cenario: Pegar usuário por id
    Dado que eu escolha a id de usuário "2" para pesquisa
    Quando realizar uma requisição "GET" na url "https://reqres.in/api/unknown/{id}"
    Então devo receber o status "200"
    E devo receber a chave "data" no retorno do serviço

  @getInvalidUserByUnknown
  Cenario: Pegar usuário inválido
    Dado que eu escolha a id de usuário "99" para pesquisa
    Quando realizar uma requisição "GET" na url "https://reqres.in/api/unknown/{id}"
    Então devo receber o status "404"