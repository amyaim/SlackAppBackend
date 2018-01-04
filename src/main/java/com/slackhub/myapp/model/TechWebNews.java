package com.slackhub.myapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TechWebNews {
    private String author;
    private String title;
    private String description;
    private String date;
    private String source;



    public TechWebNews() {

    }

    public TechWebNews(String author , String title , String description , String date) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String publishedAt) {
        this.date = publishedAt;
    }
    public String getAuthor() {
        return author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
