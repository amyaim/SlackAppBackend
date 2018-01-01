package com.slackhub.myapp.controller;
import com.slackhub.myapp.model.FamousQuotes;
import com.slackhub.myapp.service.FamousQuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping ("/famousQuote")
@CrossOrigin(origins = "http://localhost:4200")
public class FamousQuoteController {
    @Autowired
    FamousQuoteService famousQuoteService;

    @GetMapping
    public ResponseEntity<FamousQuotes> getQuotes() {

        FamousQuotes quotes = new FamousQuotes();
        quotes = famousQuoteService.getQuotes(quotes);

        return new ResponseEntity<FamousQuotes>(quotes , HttpStatus.OK);

    }
}