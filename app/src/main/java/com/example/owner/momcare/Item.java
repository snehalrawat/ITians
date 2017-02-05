package com.example.owner.momcare;

/**
 * Created by Owner on 04-02-2017.
 */


public class Item {
    int img;
    String mainText,subText;
    public Item(int img, String mainText, String subText){
        this.img=img;
        this.mainText = mainText;
        this.subText = subText;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }
}