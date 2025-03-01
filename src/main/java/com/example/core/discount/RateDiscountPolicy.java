package com.example.core.discount;

import com.example.core.member.Grade;
import com.example.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy{
    private int discountPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            int result = price * discountPercent / 100;
            return result;
        } else {
            return 0;
        }
    }
}
