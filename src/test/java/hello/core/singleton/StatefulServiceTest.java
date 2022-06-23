package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : A 사용자가 1만원을 주문
        int priceA =  statefulService1.order("userA", 10000);
        // ThreadB : B 사용자가 2만원을 주문
        int priceB = statefulService2.order("userB", 20000);

        // ThreadA : A 사용자가 주문 금액 조회
        //int price = statefulService1.getPrice();
        System.out.println("price A= " + priceA);
        System.out.println("price B= " + priceB);
        assertThat(priceA).isEqualTo(10000);
        assertThat(priceB).isEqualTo(20000);
    }
    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return  new StatefulService();
        }
    }
}