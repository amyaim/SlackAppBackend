package com.slackhub.myapp.controller;

import com.slackhub.myapp.model.Articles;
import com.slackhub.myapp.model.TechWebNews;
import com.slackhub.myapp.service.TechNewsService;
import com.slackhub.myapp.service.WebTechNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/webTechNews")
@CrossOrigin(origins = "http://localhost:4200")
public class WebTechNewsController {

    @Autowired
    WebTechNewsService webTechNewsService;

    @GetMapping
    public ResponseEntity<TechWebNews> getNews(){
        TechWebNews techNews = new TechWebNews();
        techNews= this.webTechNewsService.getTechNews();
        return  new ResponseEntity<TechWebNews>(techNews, HttpStatus.OK);
    }
}
