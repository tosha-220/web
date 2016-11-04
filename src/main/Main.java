package main;

import model.Contact;
import model.ContactType;
import model.Link;

public class Main {


    public static void main(String[] args) {
        Contact c= new Contact(ContactType.PHONE,"124324");
        Link link=new Link();
        System.out.println(link);
        link.getClass().getFields();
    }
}
