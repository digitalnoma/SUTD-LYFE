package com.example.hamburgermenu.food;

public class ServerData {
    static String[] newsTitle;
    static String[] newsDate;


    //Constructor Method
    public ServerData(String[] array1, String[] array2) {
        this.newsTitle = array1;
        this.newsDate = array2;
    }

    public static String[] getNewsTitle() {
        return newsTitle;
    }

    public String[] getNewsDate() {
        return newsDate;
    }
}
