package com.example.ddd.order.infrastructure;

import com.example.ddd.member.application.MemberQueryService;
import com.example.ddd.member.domain.Member;
import com.example.ddd.order.domain.Orderer;
import com.example.ddd.order.domain.domainService.OrdererService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrdererServiceImpl implements OrdererService {
    private final MemberQueryService memberQueryService;
    @Override
    public Orderer createOrderer(Long memberId) {
        Member member = memberQueryService.findById(memberId);
        return new Orderer(memberId,member.getName(),member.getGrade());
    }
}
