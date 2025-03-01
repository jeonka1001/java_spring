package com.example.core.repository;

import com.example.core.member.Member;

public interface MemberRepository {

    void save(Member member);
    Member findById(Long memberId);
}
