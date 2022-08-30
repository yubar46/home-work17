package service;

import repository.BaseRepository;

import java.util.List;

public class BaseServiceImpl<T, ID, R extends BaseRepository<T, ID>> implements BaseService<T, ID> {


    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }


    @Override
    public void create(T t) {
        try {
            repository.beginTransaction();
            repository.create(t);
            repository.commitTransaction();
        } catch (Exception e) {
            repository.rollbackTransaction();
            throw e;
        }

    }

    @Override
    public T read(ID id) {
        T t = repository.find(id);

        return t;
    }

    @Override
    public T update(T t) {
        try {
            repository.beginTransaction();
            t = repository.update(t);
            repository.commitTransaction();
            return t;

        } catch (Exception e) {
            repository.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void delete(ID id) {

        try {
            repository.beginTransaction();
            repository.delete(id);
            repository.commitTransaction();
        } catch (Exception e) {
            repository.getTransaction().rollback();
            throw e;
        }

    }

    @Override
    public List<T> findAll(T t) {

        return repository.findAll(t);

    }


}
