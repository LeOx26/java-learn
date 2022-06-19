package com.example.demo.controllers;

import com.example.demo.responses.StringResponse;
import com.example.demo.responses.StringRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controllers {

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public String sayHello() {
        return "Bienvenidos a la Pokedex" +
                "\nPara cargar un pokemon ingresa a /carga e introduce los datos en el siguiente formato: " +
                "\n{" +
                "\n\"kdex_id\":\"1\"" +
                "\n\"pokemon\":\"Balbasaur\"" +
                "\n\"altura\":\"0,7m\"" +
                "\n\"peso\":\"0,67kg\"" +
                "\n\"categoria\":\"Semilla\"" +
                "}";
    }

    @PostMapping(value = "/carga", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public StringResponse carga(@RequestBody StringRequest user_client) {

        String n = "Carga Exitosa";
        return new StringResponse(n);
    }
}
