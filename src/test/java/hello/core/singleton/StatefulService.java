package hello.core.singleton;

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
