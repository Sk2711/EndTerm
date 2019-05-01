package com.example.dell.endterm;

public class Information {

    public String Name;
    public String Phone;
    public int Photo;


    public Information(String name, String phone, int photo) {
        this.Name = name;
        this.Phone = phone;
        this.Photo = photo;
    }

    public String getName() {
        return Name;
    }

    public String getPhone() {
        return Phone;
    }

    public int getPhoto() {
        return Photo;
    }
}
