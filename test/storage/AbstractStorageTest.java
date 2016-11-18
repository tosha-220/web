package storage;

import exception.WebAppException;
import model.Contact;
import model.ContactType;
import model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AbstractStorageTest {
    private Resume R1, R2, R3, R4;

    protected IStorage storage;
    @BeforeClass
    public static void beforeClass() {

    }

    @Before
    public void before() {
        R1 = new Resume("one", "Имя1", "Location1");
        R1.addContact(new Contact(ContactType.MAIL, "tosha-220@yandex.ru"));
        R1.addContact(new Contact(ContactType.PHONE, "12345"));

        R4 = new Resume("one", "Имя1", "Location1");
        R4.addContact(new Contact(ContactType.MAIL, "tosha-320@yandex.ru"));
        R4.addContact(new Contact(ContactType.MOBILE, "5555555"));


        R2 = new Resume("Name2", "Location2");
        R2.addContact(new Contact(ContactType.SKYPE, "tosha-220"));
        R2.addContact(new Contact(ContactType.PHONE, "233333"));

        R3 = new Resume("Имя3", null);
        R3.addContact(new Contact(ContactType.MAIL, "tosha-220@yandex.ru"));
        R3.addContact(new Contact(ContactType.PHONE, "12345"));
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void testClear() throws Exception {
        storage.clear();

        Assert.assertEquals(0, storage.size());

    }

    @Test(expected = WebAppException.class)
    public void testSavePresented() throws Exception {
        storage.save(R1);
    }

    @Test(expected = WebAppException.class)
    public void testUpdateMissed() throws Exception {
        Resume resume=new Resume("dummy","fullName_UI","location_UI");
        storage.update(resume);
    }

    @Test
    public void testUpdate() throws Exception {
        R2.setFullName("Updeted N2");
        storage.update(R2);
        Assert.assertEquals(R2, storage.load(R2.getUuid()));

    }

    @Test
    public void testLoad() throws Exception {
        Assert.assertEquals(R2, storage.load(R2.getUuid()));
        Assert.assertEquals(R1, storage.load(R1.getUuid()));
        Assert.assertEquals(R3, storage.load(R3.getUuid()));
    }

    @Test(expected = WebAppException.class)
    public void testDeleteNotFound() throws Exception {
        storage.load("dummy");
    }

    @Test
    public void testDelete() throws Exception {
        storage.delete(R1.getUuid());
        Assert.assertEquals(2, storage.size());

    }

    @Test(expected = WebAppException.class)
    public void testDeleteMissed() throws Exception {
        storage.delete("dummy");
    }

    @Test
    public void testGetAllSorted() throws Exception {
        List<Resume> list=Arrays.asList(R1,R2,R3);
        Collections.sort(list);
        Assert.assertEquals(list, storage.getAllSorted());

    }

    @Test
    public void testSize() throws Exception {
        Assert.assertEquals(3, storage.size());
    }
}
