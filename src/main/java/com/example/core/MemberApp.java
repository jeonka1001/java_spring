package com.example.core;

import com.example.core.member.Grade;
import com.example.core.member.Member;
import com.example.core.repository.MemberRepositoryImpl;
import com.example.core.service.MemberService;
import com.example.core.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // Annotation 기반 Spring Context 생성

        MemberService memberService = applicationContext.getBean("memberService", MemberService.class); // 기본적으로 method 이름으로 bean 등록이 된다

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);

        System.out.println(member.getName());
        System.out.println(findMember.getName());
    }
}
