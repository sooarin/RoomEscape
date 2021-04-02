package com.example.room10.Model;

public class Escape {
    public int id;
    public String region,theme,cafe,room, link;
    public Escape(int id, String region, String theme, String cafe, String room, String link){
        this.id = id;
        this.region = region;
        this.theme = theme;
        this.cafe = cafe;
        this.room = room;
        this.link = link;
    }
    public Escape() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getCafe() {
        return cafe;
    }

    public void setCafe(String cafe) {
        this.cafe = cafe;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String url) {
        this.link = url;
    }
}
