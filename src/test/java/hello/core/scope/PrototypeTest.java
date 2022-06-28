package hello.core.scope;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeTest {
    @Test
    void protoTypeTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeTest.ProtoTypeBean.class);
        System.out.println("find prototypeBean1");
        PrototypeTest.ProtoTypeBean protoTypeBean1 = ac.getBean(PrototypeTest.ProtoTypeBean.class);
        System.out.println("find prototypeBean2");
        PrototypeTest.ProtoTypeBean protoTypeBean2 = ac.getBean(PrototypeTest.ProtoTypeBean.class);
        System.out.println("ProtoTypeBean1 = " + protoTypeBean1);
        System.out.println("ProtoTypeBean2 = " + protoTypeBean2);
        assertThat(protoTypeBean1).isNotSameAs(protoTypeBean2);
        ac.close();
    }
    @Scope("prototype")
    static class ProtoTypeBean{
        @PostConstruct
        public void init(){
            System.out.println("ProtoTypeBean.init");
        }
        @PreDestroy
        public void destory(){
            System.out.println("ProtoTypeBean.destory");
        }
    }
}
