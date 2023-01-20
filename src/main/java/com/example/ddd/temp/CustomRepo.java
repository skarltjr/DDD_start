package com.example.ddd.temp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.util.Assert;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public class CustomRepo implements CrudRepository<MyEntity, Long> {
    @Override
    @Transactional
    public <S extends MyEntity> S save(S entity) {
        String currentTransactionName = TransactionSynchronizationManager.getCurrentTransactionName();
        return null;
    }

    @Override
    public <S extends MyEntity> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<MyEntity> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<MyEntity> findAll() {
        return null;
    }

    @Override
    public Iterable<MyEntity> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(MyEntity entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends MyEntity> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
