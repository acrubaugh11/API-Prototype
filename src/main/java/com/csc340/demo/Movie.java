package com.csc340.demo;

public class Movie {
    public String title;
    public String episode_id;
    public String opening_crawl;
    public String release_date;

    public Movie(String title, String episode_id, String opening_crawl, String release_date){
        this.title = title;
        this.opening_crawl = opening_crawl;
        this.episode_id = episode_id;
        this.release_date = release_date;

    }

    public String getTitle(){
        return title;
    }

    public String getEpisode_id(){
        return episode_id;
    }

    public String getRelease_date(){
        return release_date;
    }
}
