package project.service;

import java.util.List;

public interface CRUDService<T, S, U, D> {

    /**
     * finds all DTOs of a given type existing in the database
     * @return a list of all those objects
     */
    public List<T> findAll();

    /**
     * finds a single object thanks to its id
     * @param id a unique string of characters
     * @return the object that has been found, is empty if the search was fruitless
     */
    public T find(String id);

    /**
     * creates an object entity inside the database
     * @param obj the object DTO we want to save in the db
     * @return a DTO copy of the object saved
     */
    public T save(S obj);

    /**
     * changes one or several values of an object stored on the database
     * @param obj the object containing the new values to apply
     * @return the changed object
     */
    public T update(U obj);

    /**
     * deletes an object from the database
     * @param obj the object to delete
     */
    public void delete(D obj);
}
