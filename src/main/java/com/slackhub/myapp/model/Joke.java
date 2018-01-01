package com.slackhub.myapp.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Joke {
  private  Integer id;
  private  String type;
  private  String setup;
  private  String punchline;

    public Joke() {

    }

    public Joke(String type , String setup , String punchline) {
        this.type = type;
        this.setup = setup;
        this.punchline = punchline;
    }

    public Integer getId() {
        return id;
    }


    public String getType() {
        return type;
    }

    public String getSetup() {
        return setup;
    }

    public String getPunchline() {
        return punchline;
    }
}
