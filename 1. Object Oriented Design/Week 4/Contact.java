/* Written by https://hawshemi.com */

package com.example.sharingapp;

import java.util.UUID;


public class Contact {
    private String username;
    private String email;
    private String id;

    public Contact(String username, String email, String id) {
        this.username = username;
        this.email = email;
        if (id == null){
            setId();
        } else {
            updateId(id);
        }
    }

    public String getId(){
        return this.id;
    }
    public void setId(){
        this.id = UUID.randomUUID().toString();
    }
    public void updateId(String id){
        this.id = id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(){
        this.username = UUID.randomUUID().toString();
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(){
        this.email = UUID.randomUUID().toString();
    }
}
