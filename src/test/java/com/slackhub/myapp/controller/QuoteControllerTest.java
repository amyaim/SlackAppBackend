package com.slackhub.myapp.controller;

import com.slackhub.myapp.model.FamousQuotes;
import com.slackhub.myapp.service.QuoteService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

@WebMvcTest(FamousQuoteController.class)
@RunWith(SpringRunner.class)
public class QuoteControllerTest {

    FamousQuotes famousQuotes;
    String mockJsonQuote;

    @Before
    public void setup(){
        famousQuotes = new FamousQuotes("history","Sally Field", "Last year I was diagnosed with osteoporosis" );
        mockJsonQuote = "{\"cat\":\"history\",\"author\":\"Sally Field\",\"quote\":\"Last year I was diagnosed with osteoporosis\"}";
    }

    @Autowired
    MockMvc mockMvc;

    @MockBean
    QuoteService quoteService;

    @Test
    public void getQuotes() throws Exception {
        Mockito.when(quoteService.getQuotes()).thenReturn(famousQuotes);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                .get("/famousQuote").accept(MediaType.APPLICATION_JSON)).andReturn();

        int status = result.getResponse().getStatus();

        //Verification
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        String expected = mockJsonQuote;
        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }

}