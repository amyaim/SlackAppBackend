package com.slackhub.myapp.controller;

import com.slackhub.myapp.model.Articles;
import com.slackhub.myapp.model.TechRadarNews;
import com.slackhub.myapp.service.TechNewsService;
import com.slackhub.myapp.service.TechRadarNewsService;
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


@RunWith(SpringRunner.class)
@WebMvcTest(TechRadarNewsController.class)
public class TechRadarNewsControllerTest {

    TechRadarNews techRadarNews;
    String mockJsonNews;

    @Before
    public void setup(){
        techRadarNews = new TechRadarNews("Mina Muktar", "Black hole","new findings","12/12/27" );
        mockJsonNews = "{\"author\":\"Mina Muktar\",\"title\":\"Black hole\",\"description\":\"new findings\",\"date\":\"12/12/27\"}";

    }

    @Autowired
    MockMvc mockMvc;

    @MockBean
    TechRadarNewsService techRadarNewsService;
    @Test
    public void getNews() throws Exception {
        Mockito.when(this.techRadarNewsService.getTechRadarNews()).thenReturn(techRadarNews);

        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/techRadarNews")
                .accept(MediaType.APPLICATION_JSON)).andReturn();

        int status =mvcResult.getResponse().getStatus();

        String expected = mockJsonNews;

        JSONAssert.assertEquals(expected, mvcResult.getResponse().getContentAsString(), false);
    }

}