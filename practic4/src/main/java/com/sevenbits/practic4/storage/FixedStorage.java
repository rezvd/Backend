package com.sevenbits.practic4.storage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class FixedStorage<T> implements IFixedStorage<T> {
    private final static Logger logger = LoggerFactory.getLogger(FixedStorage.class);
    private HashMap<String, T> storage;
    private int maxCapacity;

    public FixedStorage(int maxCapacity) {
        storage = new HashMap<String, T>(maxCapacity);
        this.maxCapacity = maxCapacity;
    }

    public void add(String key, T value) {
        if(storage.size() == maxCapacity) {
            if(logger.isWarnEnabled()) {
                logger.warn("Couldn't add element ({}), max capacity is reached: {}", value, maxCapacity);
            }
            return;
        }
        if(storage.containsKey(key)) {
            if(logger.isWarnEnabled()) {
                logger.warn("Duplicating key, value was replaced with {}", value);
            }
            return;
        } else {
            storage.put(key, value);
            if(logger.isInfoEnabled()) {
                logger.info("Element was added: {}", value);
            }
        }
    }

    public void remove(String key) {
        if(storage.containsKey(key)) {
            storage.remove(key);
            if(logger.isInfoEnabled()) {
                logger.info("Element with key {} was deleted", key);
            }
        } else {
            if(logger.isWarnEnabled()) {
                logger.warn("Element with key {} is not found for deleting", key);
            }
        }
    }

    public T get(String key) {
        return storage.get(key);
    }

    public boolean contains(T value) {
        return storage.containsValue(value);
    }

}
