package service;

import java.util.List;

public interface BaseService<T> {
    void add(T t);
    boolean delete(String numberPlate);
    List<T> getAll();
    List<T> getFromFile();
}
