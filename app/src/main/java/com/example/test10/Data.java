package com.example.test10;

public class Data {
    private String name;
    private String ifPic;
    private String day;
    private String number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIfPic() {
        return ifPic;
    }

    public void setIfPic(String ifPic) {
        this.ifPic = ifPic;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Data(String name, String ifPic, String day, String number) {
        this.name = name;
        this.ifPic = ifPic;
        this.day = day;
        this.number = number;
    }
}
