package com.slackhub.myapp.service;

import com.slackhub.myapp.model.Articles;
import com.slackhub.myapp.model.TechRadarNews;
import com.slackhub.myapp.model.TechWebNews;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class TechRadarNewsService {
    public TechRadarNews getTechRadarNews(){

        List<TechRadarNews> articles = new ArrayList<TechRadarNews>();
        RestTemplate restTemplate = new RestTemplate();
        String jsonStr = restTemplate.getForObject("https://newsapi.org/v2/top-headlines?sources=techradar&apiKey=51a5799e4e8648f7833d95701b3a716c" , String.class);

        try {
            JSONObject json  = new JSONObject(jsonStr);
            JSONArray main  = json.getJSONArray("articles");
            for (int i = 0; i < main.length(); i++) {
                TechRadarNews article = new TechRadarNews();
                String val = main.getString(i);
                JSONObject json1 = new JSONObject(val);
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
        TechRadarNews articles1 = articles.get(index);
        return  articles1;

    }
}
