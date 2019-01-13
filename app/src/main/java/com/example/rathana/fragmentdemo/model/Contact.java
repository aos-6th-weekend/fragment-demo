package com.example.rathana.fragmentdemo.model;

import android.support.annotation.DrawableRes;

public class Contact {

    String phone,name,date;

    @DrawableRes int profile;

    public Contact() {
    }

    public Contact(String phone, String name, String date,@DrawableRes int profile) {
        this.phone = phone;
        this.name = name;
        this.date = date;
        this.profile = profile;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getProfile() {
        return profile;
    }

    public void setProfile(@DrawableRes int profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", profile=" + profile +
                '}';
    }
}
