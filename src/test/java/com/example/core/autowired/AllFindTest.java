package com.example.core.autowired;

import com.example.core.AutoAppConfig;
import com.example.core.discount.DiscountPolicy;
import com.example.core.member.Grade;
import com.example.core.member.Member;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class AllFindTest {
    
    @Test
    void findallBean() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class, DiscountService.class); // Bean 등록

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(member ,10000, "fixDiscountPolicy");

        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);

        int ratePrice = discountService.discount(member, 20000, "rateDiscountPolicy");
        assertThat(ratePrice).isEqualTo(2000);

    }
    

    @RequiredArgsConstructor
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap; // DiscountPolicy 타입의 컴포넌트를 모두 주입 받는다. -> RateDiscountPolicy, FixDiscountPolicy
        private final List<DiscountPolicy> policyList;

        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            return discountPolicy.discount(member, price);
        }
    }
}
