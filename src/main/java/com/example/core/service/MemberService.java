package com.example.core.service;

import com.example.core.member.Member;

public interface MemberService {
    void join(Member member);
    Member findMember(Long memberId);
}
