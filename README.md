# Transação API

Esta é uma API para gerenciar transações e estatísticas relacionadas a elas. A API é construída com Spring Boot.

## Endpoints

### Estatísticas

#### `GET /estatistica`

Endpoint responsável por buscar estatísticas de transações.

- **Parâmetros de Consulta:**
  - `intervaloBusca` (opcional): Intervalo em minutos para buscar as estatísticas. O valor padrão é `60`.

- **Respostas:**
  - `200 OK`: Busca efetuada com sucesso.
  - `400 Bad Request`: Erro na busca de estatísticas de transações.
  - `500 Internal Server Error`: Erro interno do servidor.

**Exemplo de Requisição:**
```http
GET /estatistica?intervaloBusca=30 


```
**Exemplo de Resposta:**
```http
{
  "count": 9007199254740991,
  "sum": 0.1,
  "avg": 0.1,
  "min": 0.1,
  "max": 0.1
}
```
### Transações

#### `POST /transacao`

Endpoint responsável por adicionar transações.

**Corpo da Requisição:**


TransacaoRequestDTO: Objeto que contém os dados da transação a ser adicionada.

- **Respostas:**
  - `201 Created:` Transação gravada com sucesso.
  - `422 Unprocessable Entity:` Campos não atendem os requisitos da transação.
  - `400 Bad Request:` Erro de requisição.
  - `500 Internal Server Error:` Erro interno do servidor.

**Exemplo de Resposta:**
```http
{
  "valor": 100,
  "dataHora": "2025-01-28T13:19:19.688Z"
}
```

### Deletar Transações


Endpoint responsável por deletar transações.

#### `DELETE: /transacao`

Descrição: Deleta todas as transações armazenadas no sistema.
- **Respostas:**
  - `200 OK:` Transações deletadas com sucesso.
  - `400 Bad Request:` Erro na requisição.
  - `500 Internal Server Error:` Erro interno do servidor.

**Estrutura de Pacotes**

`com.richard.transacao_api.controller:` Contém os controladores que expõem os endpoints da API.

`com.richard.transacao_api.business.services:` Contém a lógica de negócios que manipula as transações e as estatísticas.

`com.richard.transacao_api.controller.dtos:` Contém os Data Transfer Objects (DTOs) usados para as requisições e respostas.

**Dependências**
A API utiliza o Spring Boot para criar o servidor e a interface Swagger para documentação dos endpoints. As dependências incluem:

- `Spring Web`
- `Spring Boot`
- `Swagger (OpenAPI v3)`

**Como Executar** 

  - `Clone o repositório.`
  - `Compile o projeto com mvn clean install.`
  - `Execute o projeto com mvn spring-boot:run.`
  - `Acesse a API em http://localhost:8080.`
