package model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Resume implements Comparable<Resume>{
    private final String uuid;
    private String fullName;
    private String location;
    private String homePage;
    private List<Contact> contacts=new ArrayList<Contact>();
    private List<Section> sections;


    public Resume(String uuid, String fullName, String location) {
        this.uuid = uuid;
        this.fullName = fullName;
        this.location = location;
    }

    public Resume(String fullName, String location) {
        this(UUID.randomUUID().toString(), fullName, location);
    }

    public void addSection(Section section) {
        sections.add(section);

    }

    public void addContact(Contact contact) {

        contacts.add(contact);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        final Resume resume = (Resume) o;

        return uuid .equals(resume.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }

    public String getUuid() {
        return uuid;
    }

    public List<Section> getSections() {
        return sections;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLocation() {
        return location;
    }

    public String getHomePage() {
        return homePage;
    }

    public List<Contact> getContacts() {
        return contacts;
    }


    @Override
    public int compareTo(Resume o) {
        return fullName.compareTo(o.fullName);
    }
}
