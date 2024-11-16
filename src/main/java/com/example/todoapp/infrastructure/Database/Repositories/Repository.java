package com.example.todoapp.infrastructure.Database.Repositories;

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

public class Repository<T extends EntityBase> implements IRepository<T> {

    private Class<T> entityClass;

    @PersistenceContext(synchronization = SynchronizationType.SYNCHRONIZED)
    protected EntityManager entityManager;

    public Repository(){}

    public Repository(Class<T> entityClass){
        this.entityClass = entityClass;
    }


    @Override
    public T findById(UUID id) {
        return  entityManager.find(entityClass, id);
    }

    @Override
    public T find(Predicate predicate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(entityClass);
        criteriaQuery.where(predicate);
        TypedQuery<T> tpQuery = entityManager.createQuery(criteriaQuery);
        return tpQuery.getSingleResult();
    }

    @Override
    public List<T> search(Predicate predicate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = cb.createQuery(entityClass);
        Root<T> root = criteriaQuery.from(entityClass);
        criteriaQuery.where(predicate);
        TypedQuery<T> tpQuery = entityManager.createQuery(criteriaQuery);
        return tpQuery.getResultList();
    }

    @Override
    @Transactional
    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    @Override
    @Transactional
    public T update(T entity) {
        return entityManager.merge(entity);
    }

    @Override
    @Transactional
    public void delete(UUID id) {
        var entity = entityManager.find(entityClass, id);
        entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
    }
}
