package service;

import java.util.List;

public interface Base<E> {
    List<E> getAll();
    void save();
    boolean delete();
}
