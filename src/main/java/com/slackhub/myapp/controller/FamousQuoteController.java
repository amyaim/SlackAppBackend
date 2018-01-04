package com.slackhub.myapp.controller;
import com.slackhub.myapp.model.FamousQuotes;
import com.slackhub.myapp.service.QuoteService;
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
    QuoteService quoteService;

    @GetMapping
    public ResponseEntity<FamousQuotes> getQuotes() {

        FamousQuotes quotes = quoteService.getQuotes();

        return new ResponseEntity<FamousQuotes>(quotes , HttpStatus.OK);

    }
}