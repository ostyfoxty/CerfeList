package com.example.cerfelist.classes;

public class Worker extends Human {

    public Worker(String name,String surname, int ID){
        this.name=name;
        this.surname=surname;
        this.ID=ID;
    }

    public Worker(String name,String surname, int ID, String position){
        this.name=name;
        this.surname=surname;
        this.position=position;
        this.ID=ID;
    }
}

