package com.spbstu.lab5.entities;

import com.spbstu.lab5.enums.PAGE_DATA;

import static com.spbstu.lab5.TestEpamWebSiteSelenide.login;

public class User {
    public String name;
    public String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
    //public static void log(){
        //login(PAGE_DATA.LOGIN.str, PAGE_DATA.PASSWORD.str);
    //}
}
