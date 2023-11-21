## API Endpoints
The API provides the following endpoints:


### Autor
````bash
GET
/autores                    - Get a list of all autores
/autores/{id}               - Get an autor by Id
/autores/{musicaId}/musicas - Get all autores associated with a musica by musica Id

POST
/autores                    - Create a new autor
/autores/{autorId}/{musicaId} - Add an autor to a musica by musica Id

PUT
/autores/{id}               - Update an existing autor by Id

DELETE
/autores/{id}               - Delete an autor by Id
````

### Categoria
````bash
GET
/categorias                  - Get a list of all categorias
/categorias/{id}             - Get a categoria by Id

POST
/categorias                  - Create a new categoria

PUT
/categorias/{id}             - Update an existing categoria by Id

DELETE
/categorias/{id}             - Delete a categoria by Id
````


### Musica
````bash
GET
/musicas                          - Get a list of all musicas
/musicas/{id}                     - Get a musicas by Id
/musicas/{categoriaId}/categorias - Get all musicas associated with a categoria by categoria Id
/musicas/{musicaId}/autores       - Get all musicas associated with an autor by autor Id

POST
/musicas                          - Create a new musica
/musicas/{categoriaId}/categorias - Create a new musica associated with a categoria

PUT
/musicas/{id}                     - Update an existing musica by Id

DELETE
/musicas/{id}                     - Delete a musica by Id
````
