# Available Endpoints
1. Create Database Endpoint
Endpoint: `GET /pokemon/createDatabase`
Description: This endpoint fetches Pokémon data from an external API and saves it into the database using the PokemonRepository. The external API provides a list of Pokémon names and data, which are fetched in batches and saved asynchronously.
2. Get Pokémon by Name
Endpoint: `GET /pokemon/{name}`
Description: This endpoint retrieves a specific Pokémon by its name from the database using the PokemonRepository.
3. Get All Pokémon
Endpoint: `GET /pokemon/getAll`
Description: This endpoint retrieves all Pokémon stored in the database as a map of Pokémon names to their corresponding PokemonDTO objects.
4. Update Pokémon
Endpoint: `PUT /pokemon/`
Description: This endpoint updates a Pokémon's data in the database using the PokemonRepository. It takes a JSON payload with the updated Pokémon data (PokemonDTO) and returns the updated Pokémon.
5. Delete Pokémon
Endpoint: `DELETE /pokemon/{name}`
Description: This endpoint deletes a specific Pokémon from the database using the PokemonRepository, based on its name.
# Important Note
Before using the `GET /pokemon/createDatabase` endpoint, ensure that you have configured the external API URL and the PokemonRepository implementation correctly. The implementation of PokemonRepository should include methods for saving, updating, retrieving, and deleting Pokémon data from the database.

Please exercise caution when using the `DELETE /pokemon/{name}` endpoint, as it permanently deletes Pokémon data from the database. Always have a backup of your data before making such changes.

# Dependencies
The application uses the following major dependencies:

* Spring Boot: for building and running the application.
Maven: for dependency management.
* Java: the programming language used for the application.
* Spring Web: for building RESTful APIs.
* Java CompletableFuture: for asynchronous processing of Pokémon data.
Feel free to explore the source code and customize the application as per your requirements. Happy coding!