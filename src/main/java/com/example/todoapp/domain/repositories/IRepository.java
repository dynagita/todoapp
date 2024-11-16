package com.example.todoapp.domain.repositories;

import com.example.todoapp.domain.models.EntityBase;
import jakarta.persistence.criteria.Predicate;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

public interface IRepository<T extends EntityBase> {
    /**
     *
     * @param entity who you need to persist into database
     * @return entity with id filled;
     */
    T save(T entity);

    /**
     *
     * @param entity who you need to update into database
     * @return entity updated
     */
    T update(T entity);

    /**
     *
     * @param id key's entity you want to delete
     * @return void
     */
    void delete(UUID id);

    /**
     *
      * @param id key's entity you want to find
     * @return T who you are find for.
     */
    T findById(UUID id);

    /**
     *
     * @param predicate dynamic filters for finding register needed
     * @return T who you are find for. If there are more registers who are combined with your filter, this method is going to return the first element on collection finded.
     */
    T find(Predicate predicate);

    /**
     *
     * @param predicate dynamic filter for finding registers needed
     * @return List<T> you are searching for.
     */
    List<T> search(Predicate predicate);

}
