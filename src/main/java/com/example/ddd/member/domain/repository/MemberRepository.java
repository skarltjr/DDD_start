package com.example.ddd.member.domain.repository;

import com.example.ddd.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member,Long> {
    // jpa에 의존하지 않도록 인프라단으로 옮기며 DIP를 실현해야한다고 생각할 수 있지만
    // 레포지토리 구현 기술의 변동은 거의 없다

}
