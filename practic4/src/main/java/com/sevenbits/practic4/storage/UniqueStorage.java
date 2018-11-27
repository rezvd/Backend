package com.sevenbits.practic4.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class UniqueStorage<T> implements IUniqueStorage<T> {
    private final static Logger logger = LoggerFactory.getLogger(UniqueStorage.class);
    private List storage = new LinkedList();

    public void add(T value) {
        if (storage.contains(value)) {
            logger.warn("Duplicating element added: {}", value);
        }
        storage.add(value);
        if (logger.isInfoEnabled()) {
            logger.info("Element was added: {}", value);
        }
    }

    public void remove(T value) {
        if (storage.contains(value)) {
            storage.remove(value);
            if(logger.isInfoEnabled()) {
                logger.info("Element was deleted: {}", value);
            }
        } else {
            if(logger.isWarnEnabled()) {
                logger.warn("Element is not found: {}", value);
            }
        }

    }

    public boolean contains(T value) {
        return storage.contains(value);
    }

    public Iterator iterator() {
        return storage.listIterator();
    }
}
