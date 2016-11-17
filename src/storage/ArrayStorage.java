package storage;

import exception.WebAppException;
import model.Resume;

import java.util.*;

public class ArrayStorage extends AbstractStorage {
    private static final int LIMIT = 100;
    //    protected Logger logger = Logger.getLogger(getClass().getName());

    protected Resume[] array = new Resume[LIMIT];
    private int size = 0;

    @Override
    public void clear() {
        logger.info("Delete all resumes");
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    protected void doSave(Resume r) {
        int idx = getIndex(r.getUuid());
        if (idx != -1)
//            try {
//                throw new WebAppException("Resume with "+r.getUuid()+" already exist",r);
//            } catch (WebAppException e) {
//                logger.log(Level.SEVERE,e.getMessage());
//            }
            throw new WebAppException("Resume with " + r.getUuid() + " already exist", r);
        array[size++] = r;

    }

    @Override
    public void update(Resume r) {
        logger.info("Update resume with " + r.getUuid());
        int idx=getIndex(r.getUuid());
        if (idx == -1)
            throw new WebAppException("Resume with " + r.getUuid() + " not exist", r);
        array[idx]=r;

    }

    @Override
    public Resume load(String uuid) {
        logger.info("Load resume with " + uuid);
        int idx = getIndex(uuid);
        if (idx == -1)
            throw new WebAppException("Resume with " + uuid + " not exist");
        return array[idx];
    }

    @Override
    public void delete(String uuid) {
        logger.info("Delete resume with " + uuid);
        int idx=getIndex(uuid);
        if(idx==-1)
            throw new IllegalStateException("Resume with uuid " + uuid + " not found");

        int numMoved = size - idx - 1;
        if (numMoved > 0)
            System.arraycopy(array, idx+1, array, idx, numMoved);
        array[--size] = null;

    }

    @Override
    public Collection<Resume> getAllSorted() {
        Arrays.sort(array,0,size);
        return Arrays.asList(Arrays.copyOf(array,size));
    }

    @Override
    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < LIMIT; i++) {
            if (array[i] != null) {
                if (array[i].getUuid().equals(uuid)) {
                    return i;
                }
            }
        }
        return -1;
    }
}
