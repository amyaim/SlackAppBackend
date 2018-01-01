package com.slackhub.myapp.controller;

import com.slackhub.myapp.model.Articles;
import com.slackhub.myapp.model.FamousQuotes;
import com.slackhub.myapp.service.TechNewsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TechNewsController.class)
public class TechNewsControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TechNewsService techNewsService;

    Articles articles = new Articles("Mina Muktar", "Black hole","new findings","12/12/27" );
    String mockJsonNews = "{\"author\":\"Mina Muktar\",\"title\":\"Black hole\",\"description\":\"new findings\",\"date\":\"12/12/27\"}";
    @Test
    public void getNews() throws Exception {

        Mockito.when(this.techNewsService.getTechNes()).thenReturn(articles);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/techNews")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status =mvcResult.getResponse().getStatus();

        String expected = mockJsonNews;

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
    }

}