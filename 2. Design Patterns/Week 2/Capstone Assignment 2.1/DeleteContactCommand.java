package com.example.sharingapp;

import android.content.Context;

// By https://hawshemi.com on 01-Jan-2023

public class DeleteContactCommand implements Command {
    private ContactList contactList;
    private Contact contact;
    private Context context;

    public DeleteContactCommand(ContactList contactList, Contact contact, Context context) {
        this.contactList = contactList;
        this.contact = contact;
        this.context = context;
    }

    @Override
    public void execute() {
        contactList.deleteContact(contact);
        setIsExecuted(contactList.saveContacts(context));
    }
}
