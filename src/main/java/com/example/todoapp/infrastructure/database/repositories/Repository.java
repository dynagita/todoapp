package com.example.todoapp.infrastructure.database.repositories;

import com.example.todoapp.domain.models.EntityBase;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import com.example.todoapp.domain.repositories.IRepository;
import jakarta.persistence.SynchronizationType;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

/**
 * Abstract methods from repositories
 * @param <T>
 */
public class Repository<T extends EntityBase> implements IRepository<T> {

    private Class<T> entityClass;

    @PersistenceContext(synchronization = SynchronizationType.SYNCHRONIZED)
    protected EntityManager entityManager;

    /**
     * Create a new repository
     */
    public Repository(){}

    /**
     * Create a new repository
     * @param entityClass
     */
    public Repository(Class<T> entityClass){
        this.entityClass = entityClass;
    }

    /**
     * Find by id
     * @param id key's entity you want to find
     * @return
     */
    @Override
    public T findById(UUID id) {
        return  entityManager.find(entityClass, id);
    }

    /**
     * Find a register by dynamic filter, user may create your own predicate filter
     * @param predicate dynamic filters for finding register needed
     * @return
     */
    @Override
    public T find(Predicate predicate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(entityClass);
        criteriaQuery.where(predicate);
        TypedQuery<T> tpQuery = entityManager.createQuery(criteriaQuery);
        return tpQuery.getSingleResult();
    }

    /**
     * Search
     * @param predicate dynamic filter for finding registers needed
     * @return Collection
     */
    @Override
    public List<T> search(Predicate predicate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.where(predicate);
        TypedQuery<T> tpQuery = entityManager.createQuery(criteriaQuery);
        return tpQuery.getResultList();
    }

    /**
     * Persist a new entity into database
     * @param entity who you need to persist into database
     * @return
     */
    @Override
    @Transactional
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    /**
     * Update an entity into database
     * @param entity who you need to update into database
     * @return
     */
    @Override
    @Transactional
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    /**
     * Delete an entity from database
     * @param id key's entity you want to delete
     */
    @Override
    @Transactional
    public void delete(UUID id) {
        var entity = entityManager.find(entityClass, id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
