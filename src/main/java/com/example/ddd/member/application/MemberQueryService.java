package com.example.ddd.member.application;

import com.example.ddd.member.ErrorCodes;
import com.example.ddd.member.domain.Member;
import com.example.ddd.member.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberQueryService {
    private final MemberRepository memberRepository;


    public Member findById(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException(ErrorCodes.MEMBER_NOT_FOUND));
        return member;
    }
}
