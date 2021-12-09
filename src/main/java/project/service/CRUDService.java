package project.service;

import java.util.List;

public interface CRUDService<T, S, U, D> {

    public List<T> findAll();

    public T find(String id);

    public T save(S obj);

    public T update(U obj);

    public void delete(D obj);
}
