package com.example.cerfelist.classes;

public class Worker extends Human {

    public Worker(){
        this.name=null;
        this.surname=null;
    }
    public Worker(String name,String surname){
        this.name=name;
        this.surname=surname;
    }

    public Worker(String name,String surname, String position){
        this.name=name;
        this.surname=surname;
        this.position=position;
    }
}

