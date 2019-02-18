# Books


Somente uma api para listar e cadastrar livros.

[![Build Status](https://travis-ci.com/gconsentini/books.svg?branch=master)](https://travis-ci.com/gconsentini/books)

[![codecov](https://codecov.io/gh/gconsentini/books/branch/master/graph/badge.svg)](https://codecov.io/gh/gconsentini/books)

## Tecnologias utilizadas

- Java 8
- Springboot
- H2
- Lombok
- Swagger
- Junit
- Jacoco
- Docker, Docker-compose
- TravisCI
- Codecov

## O que é necessário para rodar a API

- [Docker](https://www.docker.com/)
- [Docker-compose](https://docs.docker.com/compose/)

## Instruções
```
$ ./mvnw clean install
$ docker-compose up
```

A partir disso a mesma estará disponivel em:

http://localhost:8080//book

http://localhost:8080/books/{bookId}

http://localhost:8080/books


### Swagger
http://localhost:8080/swagger-ui.html

No swagger tem a documentação da api, como rodar e ui para testar a api.

## API

**`POST -> /book`**

Cria um livro e salva na base do H2

```json
{
  "description": "string",
  "isbn": "string",
  "language": "string",
  "title": "string"
}
```
Caso Ok:
**RETORNO HTTP 200-OK**

**`GET -> /books/{bookId}`**

Retorna um livro criado na base por ID

**Retorno**

```json
{
  "description": "string",
  "id": 0,
  "isbn": "string",
  "language": "string",
  "title": "string"
}
```


**`GET -> /books`**

Retorna todos os livros na base, incluindo os livros coletados pelo crawler.
Esses livros são populados na primeira vez que a aplicação sobe, visto que o H2 é um banco em memória.

**Retorno**

```json
{
  "books": [
    {
      "description": "string",
      "id": 0,
      "isbn": "string",
      "language": "string",
      "title": "string"
    }
  ],
  "numberBooks": 0
}
```
