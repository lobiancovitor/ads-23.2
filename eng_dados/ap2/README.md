## API Endpoints
The API provides the following endpoints:


### AutorController
````bash
GET
/autores                    - Get a list of all autores
/autores/{id}               - Get an autor by Id
/musicas/{musicaId}/autores - Get all autores associated with a musica by musica Id
/autores/{autorId}/musicas  - Get all musicas associated with an autor by autor Id

POST
/autores                    - Create a new autor
/musicas/{musicaId}/autores - Add an autor to a musica by musica Id

PUT
/autores/{id}               - Update an existing autor by Id

DELETE
/autores/{id}               - Delete an autor by Id
````

### CategoriaController
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


### MusicaController
````bash
GET
/musicas                          - Get a list of all musicas
/musicas/{id}                     - Get a musicas by Id
/categorias/{categoriaId}/musicas - Get all musicas associated with a categoria by categoria Id
/categorias/musicas/{id}          - Get a musica by Categoria Id


POST
/categorias/{categoriaId}/musicas - Create a new musica associated with a categoria
/musicas/{musicaId}/autores       - Add an autor to a musica by musica Id

PUT
/musicas/{id}                     - Update an existing musica by Id

DELETE
/musicas/{id}                     - Delete a musica by Id
````
