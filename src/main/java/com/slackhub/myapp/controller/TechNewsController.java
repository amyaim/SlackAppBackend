package com.slackhub.myapp.controller;

import com.slackhub.myapp.model.Articles;
import com.slackhub.myapp.model.FamousQuotes;
import com.slackhub.myapp.service.TechNewsService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/techNews")
@CrossOrigin(origins = "http://localhost:4200")
public class TechNewsController {

    @Autowired
    TechNewsService techNewsService;

    @GetMapping
    public ResponseEntity<Articles> getNews(){
        Articles techNews = new Articles();
        techNews= this.techNewsService.getTechNes();
        return  new ResponseEntity<Articles>(techNews,HttpStatus.OK);
    }
}
