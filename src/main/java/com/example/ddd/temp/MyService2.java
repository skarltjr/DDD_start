package com.example.ddd.temp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class MyService2 {
    private final MyRepository myRepository;
    private final CustomRepo customRepo;

    @Transactional
    public void callInner() {
        System.out.printf(TransactionSynchronizationManager.getCurrentTransactionName() + " innerhello");
        for (int i = 4; i <= 7; i++) {
            customRepo.save(new MyEntity(null, i));
        }
        throw new IllegalArgumentException(" exception ");
    }
}
