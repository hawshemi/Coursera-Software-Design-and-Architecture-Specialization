
// By https://hawshemi.com on 29-Dec-2022


package com.example.sharingapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;


public class ContactList {
    private ArrayList<Contact> contacts;
    private String FILENAME = "contacts.sav";

    public ContactList(){
        contacts = new ArrayList<Contact>();
    }
    public void setContacts(ArrayList<Contact> contact_list) {
        this.contacts = contact_list;
    }
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
    public ArrayList<String> getAllUsernames(){
        ArrayList<String> usernames = new ArrayList<String>();
        for(Contact contact : contacts){
            usernames.add(contact.getUsername());
        }
        return usernames;
    }
    public void addContact(Contact contact){
        contacts.add(contact);
    }
    public void deleteContact(Contact contact){
        contacts.remove(contact);
    }
    public Contact getContact(int idx){
        return contacts.get(idx);
    }
    public int getSize(){
        return contacts.size();
    }
    public int getIndex(Contact contact){
        int pos = 0;
        for (Contact i : contacts) {
            if (contact.getId().equals(i.getId())) {
                return pos;
            }
            pos = pos+1;
        }
        return -1;
    }
    public boolean hasContact(Contact contact){
        return contacts.contains(contact);
    }
    public Contact getContactByUsername(String username){
        for(Contact contact : contacts){
            if(contact.getUsername().equals(username)){
                return contact;
            }
        }
        return null;
    }
    public boolean isUsernameAvailable(String username){
        ArrayList<String> usernames = getAllUsernames();
        return !usernames.contains(username);
    }

    public void loadContacts(Context context) {

        try {
            FileInputStream fis = context.openFileInput(FILENAME);
            InputStreamReader isr = new InputStreamReader(fis);
            Gson gson = new Gson();
            Type listType = new TypeToken<ArrayList<Contact>>() {}.getType();
            contacts = gson.fromJson(isr, listType); // temporary
            fis.close();
        } catch (FileNotFoundException e) {
            contacts = new ArrayList<Contact>();
        } catch (IOException e) {
            contacts = new ArrayList<Contact>();
        }
    }

    public void saveContacts(Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(FILENAME, 0);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            Gson gson = new Gson();
            gson.toJson(contacts, osw);
            osw.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
