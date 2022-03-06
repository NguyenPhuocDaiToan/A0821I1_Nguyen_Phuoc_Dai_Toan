package service;

import java.util.List;

public interface BaseService<E> {
    List<E> getAll();
    void save(E e);
    boolean delete(int id);
}
