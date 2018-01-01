package com.slackhub.myapp.controller;

import com.slackhub.myapp.model.FamousQuotes;
import com.slackhub.myapp.model.Joke;
import com.slackhub.myapp.service.JokeService;
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

@RunWith(SpringRunner.class)
@WebMvcTest(JokeController.class)
public class JokeControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    JokeService jokeService;
    Joke joke = new Joke("tech","What is the synonyms of stress", "Angular" );
    String mockJsonJoke = "{\"type\":\"tech\",\"setup\":\"What is the synonyms of stress\",\"punchline\":\"Angular\"}";

    @Test
    public void getJoke() throws Exception {

        Mockito.when(this.jokeService.getJoke(Mockito.any(Joke.class))).thenReturn(joke);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/joke")
                .accept(MediaType.APPLICATION_JSON))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
        String expected = mockJsonJoke;
        JSONAssert.assertEquals(expected, mvcResult.getResponse()
                .getContentAsString(), false);
    }

}