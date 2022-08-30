package service;

import java.util.List;

public interface BaseService<T, ID> {
    void create(T t);

    T read(ID id);

    T update(T t);

    void delete(ID id);

    List<T> findAll(T t);


}
