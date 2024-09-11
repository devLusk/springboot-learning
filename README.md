# Notes Manager API

Este projeto é uma API RESTful para gerenciar notas, construída usando Spring Boot. Ele permite criar, listar, atualizar e deletar notas de uma base de dados.

## Tecnologias Utilizadas

- **Spring Boot** - Framework principal para desenvolvimento da API.
- **Spring Data JPA** - Para interação com o banco de dados.
- **Lombok** - Para reduzir o código boilerplate, como getters, setters e construtores.
- **H2 Database** (opcional) - Banco de dados em memória para testes (se configurado).

## Estrutura do Projeto

- `Notes.java`: Classe de entidade que representa a tabela de notas no banco de dados.
- `NotesController.java`: Controlador que lida com as requisições HTTP e faz a ponte com o repositório.
- `NotesRepository.java`: Repositório que permite realizar operações CRUD na entidade `Notes`.

## Endpoints

### Listar todas as notas
- **URL**: `/notes`
- **Método**: `GET`
- **Resposta**: Retorna uma lista de todas as notas.

### Obter uma nota pelo ID
- **URL**: `/notes/{id}`
- **Método**: `GET`
- **Resposta**: Retorna a nota com o ID especificado.

### Criar uma nova nota
- **URL**: `/notes`
- **Método**: `POST`
- **Corpo da Requisição**:
  ```json
  {
    "title": "Título da nota",
    "content": "Conteúdo da nota"
  }
