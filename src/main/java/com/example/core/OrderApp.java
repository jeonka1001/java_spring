package com.example.core;

import com.example.core.discount.FixDiscountPolicy;
import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.order.Order;
import com.example.core.repository.MemberRepositoryImpl;
import com.example.core.service.MemberService;
import com.example.core.service.MemberServiceImpl;
import com.example.core.service.OrderService;
import com.example.core.service.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext app = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = app.getBean("memberService", MemberService.class);
        OrderService orderService = app.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order = " + order);
        System.out.println("Order.calculatePrice = " + order.calculatorPrice());
    }
}
