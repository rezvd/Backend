package com.sevenbits.practic4.storage;


public interface IFixedStorage<T> {

    void add(String key, T value);

    void remove(String key);

    T get(String key);

    boolean contains(T value);
}
