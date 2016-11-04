package main;

import model.Contact;
import model.ContactType;
import model.Resume;
import storage.ArrayStorage;

public class Main {


    public static void main(String[] args) {
        Resume R1, R2, R3;
        ArrayStorage storage = new ArrayStorage();
        R1 = new Resume("Имя1", "Location1");
        R1.addContact(new Contact(ContactType.MAIL, "tosha-220@yandex.ru"));
        R1.addContact(new Contact(ContactType.PHONE, "12345"));


        R2 = new Resume("Name2", "Location2");
        R2.addContact(new Contact(ContactType.SKYPE, "tosha-220"));
        R2.addContact(new Contact(ContactType.PHONE, "233333"));

        R3 = new Resume("Имя3", null);
        R3.addContact(new Contact(ContactType.MAIL, "tosha-220@yandex.ru"));
        R3.addContact(new Contact(ContactType.PHONE, "12345"));
//        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }
}
