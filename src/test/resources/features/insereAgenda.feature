#language: pt

Funcionalidade: Cadastrando na agenda
  Cenario: Com sucesso
    Dado o endpoint POST /agenda "<descricao>"
    Quando a requisicao contendo todas as informacoes corretas "<payloadRequest>"
    Então receberei statusCode "<statusCode>"
    E o payload de response será exibido com sucesso "<payloadResponse>"
    Exemplos:
      |descricao          |payloadRequest   |statusCode   |payloadResponse  |
      |Caso de sucesso    |sucessoRequest   |201          |sucessoResponse  |