package storage;

import exception.WebAppException;
import model.Resume;

import java.util.logging.Logger;

public abstract class AbstractStorage implements IStorage {

    private static final int LIMIT = 100;
    protected Logger logger = Logger.getLogger(ArrayStorage.class.getName());


    protected Resume[] array = new Resume[LIMIT];
    private int size = 0;
    @Override
    public void save(Resume r) {
        logger.info("Save resume with uuid = " + r.getUuid());
        //TODO try to move exception here
        doSave(r);
        
    }

    protected abstract void doSave(Resume r);
}
