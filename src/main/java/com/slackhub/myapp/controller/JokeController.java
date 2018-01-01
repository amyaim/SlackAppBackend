package com.slackhub.myapp.controller;


import com.slackhub.myapp.model.Joke;
import com.slackhub.myapp.service.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/joke")
@CrossOrigin(origins = "http://localhost:4200")
public class JokeController {

    @Autowired
    JokeService jokeService;

    @GetMapping

    public ResponseEntity<Joke> getJoke(){
        Joke joke = new Joke();
          joke=  this.jokeService.getJoke(joke);

        return new ResponseEntity<Joke>(joke, HttpStatus.OK);
    }
}
