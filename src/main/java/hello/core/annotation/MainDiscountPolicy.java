package hello.core.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD}) // 어노테이션 적용 대상을 지정
@Retention(RetentionPolicy.RUNTIME) // 어노테이션 유지 기간을 런타임 시점까지 유지
@Inherited
@Documented
@Qualifier("mainDiscountPolicy")
public @interface MainDiscountPolicy {
}
