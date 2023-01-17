package com.example.ddd.order.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

}
/*
* 특정 기술에 의존하지 않는 순수 도메인을 위해선 기술 구현체를 인프라에 위치시켜야하지만
* 실질적으로 repo 기술은 거의 변경이없기에 도메인에 위치시킨다.
* */
