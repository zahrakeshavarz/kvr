package com.example.myapplication;

public class Suggestion {
    public int position;
    public double rate;
    public NewsModel news;

    public Suggestion(int position, double rate, NewsModel news) {
        this.position = position;
        this.rate = rate;
        this.news = news;
    }
}
