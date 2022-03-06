package dao;

import java.util.List;

public interface BaseDAO <T>{
    List<T> getAll();
    boolean add(T t);
    boolean edit(T t);
    boolean delete(int id);
    List<T> search(String value);
}
