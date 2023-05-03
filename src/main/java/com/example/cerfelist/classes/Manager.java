package com.example.cerfelist.classes;



public class Manager extends Human {

    public Manager(){
        this.name=null;
        this.surname=null;
        this.login=null;
        this.password=null;
        this.position=null;
    }

    public Manager(String name,String surname, String login, String password){
        this.name=name;
        this.surname=surname;
        this.login=login;
        this.password=password;
        this.position=null;
    }
    public Manager(String name,String surname, String position,String login, String password){
        this.name=name;
        this.surname=surname;
        this.position=position;
        this.login=login;
        this.password=password;
    }

}
