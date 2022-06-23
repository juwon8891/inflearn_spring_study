package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class StatefulService {
    //private int price; // 가격 상태를 유지하는 필드
    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        //this.price = price; // 여기가 문
        return price;
    }
   // public int getPrice(){
        //return price;
   //}
}
