package com.sevenbits.practic4.storage;

public interface IUniqueStorage<T> extends Iterable{

    void add(T value);

    void remove(T value);

    boolean contains(T value);
}
