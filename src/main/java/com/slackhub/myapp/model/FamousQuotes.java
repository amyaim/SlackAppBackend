package com.slackhub.myapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FamousQuotes {

    private String cat;
    private String author;
    private String quote;

    public FamousQuotes(String cat , String author , String quote) {
        this.cat = cat;
        this.author = author;
        this.quote = quote;
    }

    public FamousQuotes() {

    }

    public void setCat(String title) {
        this.cat = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getCat() {
        return cat;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }
}
