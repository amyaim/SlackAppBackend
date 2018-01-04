package com.slackhub.myapp.controller;

import com.slackhub.myapp.model.Articles;
import com.slackhub.myapp.model.TechRadarNews;
import com.slackhub.myapp.model.TechWebNews;
import com.slackhub.myapp.service.TechNewsService;
import com.slackhub.myapp.service.TechRadarNewsService;
import com.slackhub.myapp.service.WebTechNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/techRadarNews")
@CrossOrigin(origins = "http://localhost:4200")
public class TechRadarNewsController {

    @Autowired
    TechRadarNewsService techRadarNewsService;

    @GetMapping
    public ResponseEntity<TechRadarNews> getNews(){
        TechRadarNews techRadarNews = new TechRadarNews();
        techRadarNews= this.techRadarNewsService.getTechRadarNews();
        return  new ResponseEntity<TechRadarNews>(techRadarNews, HttpStatus.OK);
    }
}
