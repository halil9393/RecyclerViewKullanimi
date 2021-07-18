package com.example.recyclerviewkullanimi;

public class MyModel {

    int resID,kacyildiz;
    String leveltext, zamansiniritext, hamlesiniritext,level;

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public int getKacyildiz() {
        return kacyildiz;
    }

    public void setKacyildiz(int kacyildiz) {
        this.kacyildiz = kacyildiz;
    }

    public String getLeveltext() {
        return leveltext;
    }

    public void setLeveltext(String leveltext) {
        this.leveltext = leveltext;
    }

    public String getZamansiniritext() {
        return zamansiniritext;
    }

    public void setZamansiniritext(String zamansiniritext) {
        this.zamansiniritext = zamansiniritext;
    }

    public String getHamlesiniritext() {
        return hamlesiniritext;
    }

    public void setHamlesiniritext(String hamlesiniritext) {
        this.hamlesiniritext = hamlesiniritext;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public MyModel(int resID, String leveltext, String zamansiniritext, String hamlesiniritext, String level, int kacyildiz){
        this.resID=resID;
        this.leveltext=leveltext;
        this.zamansiniritext=zamansiniritext;
        this.hamlesiniritext=hamlesiniritext;
        this.level=level;
        this.kacyildiz = kacyildiz;
    }
}
