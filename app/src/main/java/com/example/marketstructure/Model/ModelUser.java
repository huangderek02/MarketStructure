// @author Ratchanont Treevijitpaisan (u7444134)
package com.example.marketstructure.Model;

public class ModelUser {

    String email;
    String name;


    public ModelUser(){}

    public ModelUser(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName() {return name;}

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
