package Dao;

import java.util.ArrayList;
import java.util.Optional;

public interface Dao<T> {
    T get(Integer ID);
    ArrayList<T> getAll();
    void save(T t);
    void update (T t);
    void delete (T t);
}
