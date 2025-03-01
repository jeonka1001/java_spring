package com.example.core.scan;

import com.example.core.AutoAppConfig;
import com.example.core.service.MemberService;
import com.example.core.service.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        AssertionsForClassTypes.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
