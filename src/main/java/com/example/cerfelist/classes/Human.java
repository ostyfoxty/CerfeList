package com.example.cerfelist.classes;


public abstract class Human {
    String name;
    String surname;
    String position;
    boolean profUnion;
    String login;
    String password;
    int ID;


    //getters

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public String getPosition() {
        return position;
    }
    public boolean getProfUnion() {
        return profUnion;
    }
    public String getLogin() {return login;}
    public String getPassword() {return password;}
    public int getID() {return ID;}

    //setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setName(boolean name) {
        this.profUnion = profUnion;
    }
    public void setLogin(String login) {this.login = login;}
    public void setPassword(String password) {this.password = password;}
    public void setID(int ID) {this.ID = ID;}

    //methods
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result + ((position == null) ? 0 : position.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Human other = (Human) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (surname == null) {
            if (other.surname != null)
                return false;
        } else if (!surname.equals(other.surname))
            return false;
        return true;
    }

    public String toString() {
        return "Human [name=" + name + ", surname=" + surname +", position=" + position + "]";
    }

}


