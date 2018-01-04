package com.slackhub.myapp.controller;

import com.slackhub.myapp.model.TechRadarNews;
import com.slackhub.myapp.model.TechWebNews;
import com.slackhub.myapp.service.TechRadarNewsService;
import com.slackhub.myapp.service.WebTechNewsService;
import org.junit.Before;
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
@WebMvcTest(WebTechNewsController.class)
public class WebTechNewsControllerTest {

    TechWebNews techWebNews;
    String mockJsonNews;

    @Before
    public void setup(){
        techWebNews = new TechWebNews("Mina Muktar", "Black hole","new findings","12/12/27" );
        mockJsonNews = "{\"author\":\"Mina Muktar\",\"title\":\"Black hole\",\"description\":\"new findings\",\"date\":\"12/12/27\"}";

    }

    @Autowired
    MockMvc mockMvc;

    @MockBean
    WebTechNewsService webTechNewsService;
    @Test
    public void getNews() throws Exception {
        Mockito.when(this.webTechNewsService.getTechNews()).thenReturn(techWebNews);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/webTechNews")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status =mvcResult.getResponse().getStatus();

        String expected = mockJsonNews;

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
    }

}