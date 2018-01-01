package com.slackhub.myapp.service;

import com.slackhub.myapp.model.FamousQuotes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FamousQuoteService {

    public FamousQuotes getQuotes(FamousQuotes famousQuotes){
        try{
            RestTemplate restTemplate = new RestTemplate();
            famousQuotes = restTemplate.getForObject("https://talaikis.com/api/quotes/random/", FamousQuotes.class);
        }catch(Exception e){
            e.printStackTrace();
        }

        return famousQuotes;

    }
}
