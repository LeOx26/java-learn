package pokedex.controllers;

import pokedex.DbActions;
import pokedex.responses.StringResponse;
import pokedex.responses.StringRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controllers {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHello() {
        return """
                Bienvenidos a la Pokedex
                Para cargar un pokemon ingresa a /carga e introduce los datos en el siguiente formato:
                {
                "kdex_id":"1",
                "pokemon":"Balbasaur",
                "altura":"0,7m",
                "peso":"0,67kg",
                "categoria":"Semilla"}""";
    }

    @PostMapping(value = "/carga", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StringResponse carga(@RequestBody StringRequest user_client) {
        String q = "INSERT INTO pokemons(\n" +
                "    kdex_id, pokemon, altura, peso, categoria\n" +
                ")\n" +
                " VALUES\n" +
                "  ( " + user_client.kdex_id + " , '" + user_client.pokemon + "', '" + user_client.altura + "', '" + user_client.peso + "', '" + user_client.categoria + "')";
        return new StringResponse(DbActions.carga(q));
    }
}
