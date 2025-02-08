package com.csc340.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class RestApiController {
    @GetMapping("/star-wars")
    public Object getMovies(){
        try{
            String url = "https://swapi.dev/api/films/1/";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            System.out.println("Making request to: " + url);
            String jsonListResponse = restTemplate.getForObject(url, String.class);

            System.out.println("API Response: " + jsonListResponse);

            JsonNode root = mapper.readTree(jsonListResponse);

            List<Movie> movieData = new ArrayList<>();

            String title = root.get("title").asText();
            String opening_crawl = root.get("opening_crawl").asText();
            String episode_id = root.get("episode_id").asText();
            String release_date = root.get("release_date").asText();

            Movie data = new Movie(title, opening_crawl, episode_id, release_date);
            movieData.add(data);

            return movieData;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE, null, ex);
            return "JSON Parsing error in /star-wars";
        } catch (Exception ex) {
            Logger.getLogger(RestApiController.class.getName()).log(Level.SEVERE, null, ex);
            return "An unexpected error occurred.";
        }
    }

}
