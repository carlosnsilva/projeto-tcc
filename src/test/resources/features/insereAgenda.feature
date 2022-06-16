#language: pt

Funcionalidade: Cadastrando na agenda
  Cenario: Com sucesso
    Dado o endpoint POST /agenda
    Quando a requisicao contendo todas as informacoes corretas
    Então receberei statusCode 201
    E o payload de response será exibido com sucesso