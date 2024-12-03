package com.example.todoapp.infrastructure.database.repositories;

import br.com.fluentvalidator.predicate.PredicateBuilder;
import com.example.todoapp.borders.models.EntityBase;
import jakarta.persistence.*;
import com.example.todoapp.borders.repositories.IRepository;
import jakarta.persistence.criteria.*;
import jakarta.transaction.Transactional;

import java.util.HashMap;
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
    public Repository() {
    }

    /**
     * Create a new repository
     * @param entityClass
     */
    public Repository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    /**
     * Find by id
     * @param id key's entity you want to find
     * @return
     */
    @Override
    @Transactional
    public T findById(UUID id) {
        return  entityManager.find(entityClass, id);
    }

    /**
     * Find a register by dynamic filter, user may create your own predicate filter
     * @param filters dynamic filters for finding register needed
     * @return
     */
    @Override
    @Transactional
    public T find(HashMap<String, Object> filters) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

        Root<T> root = criteriaQuery.from(entityClass);

        Predicate predicate = null;
        if(filters != null && filters.size() > 0){
            for(var filter : filters.entrySet()){
                if(predicate == null)
                    predicate = criteriaBuilder.equal(root.get(filter.getKey()), filter.getValue());
                else
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(filter.getKey()), filter.getValue()));
            }
        }

        criteriaQuery.select(root).orderBy(criteriaBuilder.desc(root.get("id")));
        if(predicate != null){
            criteriaQuery.where(predicate);
        }

        TypedQuery<T> tpQuery = entityManager.createQuery(criteriaQuery);

        var response = tpQuery.getResultList();
        if(response.isEmpty())
            return null;

        return response.getFirst();
    }

    /**
     * Search
     * @param filters dynamic filter for finding registers needed, key should be entity attributeName
     * @return Collection
     */
    @Override
    @Transactional
    public List<T> search(HashMap<String, Object> filters, int skip, int take) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(entityClass);

        Root<T> root = criteriaQuery.from(entityClass);

        Predicate predicate = null;
        if(filters != null && filters.size() > 0){
            for(var filter : filters.entrySet()){
                if(predicate == null)
                    predicate = criteriaBuilder.equal(root.get(filter.getKey()), filter.getValue());
                else
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get(filter.getKey()), filter.getValue()));
            }
        }

        criteriaQuery.select(root).orderBy(criteriaBuilder.desc(root.get("id")));
        if(predicate != null){
            criteriaQuery.where(predicate);
        }

        TypedQuery<T> tpQuery = entityManager.createQuery(criteriaQuery);
        tpQuery.setFirstResult(skip);
        tpQuery.setMaxResults(take);


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
