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

    public Worker(String name,String surname, int ID, boolean profUnion){
        this.name=name;
        this.surname=surname;
        this.ID=ID;
        this.profUnion=profUnion;
    }

    public Worker(String name,String surname, int ID, String position,boolean profUnion){
        this.name=name;
        this.surname=surname;
        this.position=position;
        this.ID=ID;
        this.profUnion=profUnion;
    }
}

