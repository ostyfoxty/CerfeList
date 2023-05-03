package com.example.cerfelist.classes;



public class Manager extends Human {

    public Manager(String name,String surname, int ID, String login, String password){
        this.name=name;
        this.surname=surname;
        this.ID=ID;
        this.login=login;
        this.password=password;
        this.position=null;
    }
    public Manager(String name,String surname, int ID, String position,String login, String password){
        this.name=name;
        this.surname=surname;
        this.position=position;
        this.ID=ID;
        this.login=login;
        this.password=password;
    }
}