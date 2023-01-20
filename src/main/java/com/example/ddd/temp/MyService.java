package com.example.ddd.temp;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Service
@RequiredArgsConstructor
public class MyService {
    private final MyService2 myService2;
    private final CustomRepo customRepo;
    private final MyRepository myRepository;


    @Transactional
    public void outer() {
        String outerTr = TransactionSynchronizationManager.getCurrentTransactionName();
        for (int i = 1; i <= 3; i++) {
            //myRepository.save(new MyEntity(null, i));
            customRepo.save(new MyEntity(null, i));
        }
        //inner();
        myService2.callInner();
    }

    @Transactional
    public void inner() {
        String innerTr = TransactionSynchronizationManager.getCurrentTransactionName();
        for (int i = 4; i <= 7; i++) {
            if (i == 7) {
                throw new IllegalArgumentException("exception");
            }
            customRepo.save(new MyEntity(null, i));
        }
    }
}
