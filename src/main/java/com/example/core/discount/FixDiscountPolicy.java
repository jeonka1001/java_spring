package com.example.core.discount;

import com.example.core.member.Grade;
import com.example.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{
    private int disCountFixAmount = 1000;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return disCountFixAmount;
        }
        return 0;
    }
}
