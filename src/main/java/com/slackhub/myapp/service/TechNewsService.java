package com.slackhub.myapp.service;

import com.slackhub.myapp.model.Articles;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TechNewsService {

    public Articles getTechNes(){

        List<Articles> articles = new ArrayList<Articles>();
        RestTemplate restTemplate = new RestTemplate();
        String jsonStr = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?sources=techcrunch&apiKey=51a5799e4e8648f7833d95701b3a716c" , String.class);
        JSONObject json = null;
        try {
            json = new JSONObject(jsonStr);
            JSONArray main = null;
            main = json.getJSONArray("articles");
            JSONObject json1 = null;

            for (int i = 0; i < main.length(); i++) {
                Articles article = new Articles();
                String val = main.getString(i);
                json1 = new JSONObject(val);
                article.setAuthor( json1.getString("author"));
                article.setTitle(json1.getString("title"));
                article.setDescription(json1.getString("description"));
                article.setDate(json1.getString("publishedAt"));
                article.setSource(json1.getString("url"));
                articles.add(article);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        Random random = new Random();
        int index = random.nextInt(articles.size());
        Articles articles1 = articles.get(index);
         return  articles1;

    }
}
