package com.example.core.order;

import com.example.core.AppConfig;
import com.example.core.discount.FixDiscountPolicy;
import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.repository.MemberRepositoryImpl;
import com.example.core.service.MemberService;
import com.example.core.service.MemberServiceImpl;
import com.example.core.service.OrderService;
import com.example.core.service.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Or;

public class OrderServiceTest {
    AppConfig app = new AppConfig();

    MemberService memberService = app.memberService();
    OrderService orderService = app.orderService();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "mamberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}
