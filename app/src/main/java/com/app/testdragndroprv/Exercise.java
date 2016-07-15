package com.app.testdragndroprv;

/**
 * Created by root on 27/05/16.
 */
public class Exercise {
    private String name;
    private String counter;
    private String imgUrl;

    //setter
    public Exercise(String nameV, String counterV, String imgUrlV) {
        this.name = nameV;
        this.counter = counterV;
        this.imgUrl = imgUrlV;
    }

    /*
    public void setName(String name) {
        this.name = name;
    }

    public void setCounter(String counter){
        this.counter = counter;
    }

    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }*/

    //getter
    public String getName() { return name; }
    public String getCounter() { return counter; }
    public String getImgUrl() { return imgUrl; }
}
