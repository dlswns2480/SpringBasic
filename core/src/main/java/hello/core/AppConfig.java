package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){ 
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private static DiscountPolicy discountPolicy() { //역할이 보이고
        return new RateDiscountPolicy(); //구현이 보임
    }
}
