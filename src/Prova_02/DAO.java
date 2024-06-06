package Prova_02;

import java.util.List;

public interface DAO<T> {
    void save(T type);
    T findById (int id);
    List<T> findAll();
}
