package app.repository;

import java.util.List;

public interface GenericRepository<T, ID> {
    void create(T t);
    List<T> findAll();
    void update(T t);
    void delete(T t);
    T getById(ID id);
}
