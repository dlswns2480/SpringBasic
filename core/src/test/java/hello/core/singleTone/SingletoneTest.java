package hello.core.singleTone;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SingletoneTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer(){
        AppConfig appConfig = new AppConfig();

        //1. 조회 : 호출할 때마가 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 : " + memberService1);
        System.out.println("memberService2 " + memberService2);

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);
        
    }
    
    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletoneServiceTest(){
        SingletoneService singletoneService1 = SingletoneService.getInstance();
        
        SingletoneService singletoneService2 = SingletoneService.getInstance();

        System.out.println("singletoneService1 = " + singletoneService1);
        System.out.println("singletoneService2 = " + singletoneService2);

        Assertions.assertThat(singletoneService1).isSameAs(singletoneService2);
    }
}
