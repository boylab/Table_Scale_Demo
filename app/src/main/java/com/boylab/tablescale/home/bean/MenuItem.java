package com.boylab.tablescale.home.bean;

public class MenuItem {

    private int imgRes;
    private String text;
    private Class clazz;

    public MenuItem(int imgRes, String text, Class clazz) {
        this.imgRes = imgRes;
        this.text = text;
        this.clazz = clazz;
    }

    public int getImgRes() {
        return imgRes;
    }

    public void setImgRes(int imgRes) {
        this.imgRes = imgRes;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    @Override
    public String toString() {
        return "MenuItem{" +
                "imgRes=" + imgRes +
                ", text='" + text + '\'' +
                ", clazz=" + clazz +
                '}';
    }
}
