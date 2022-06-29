package hello.core.scope;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Provider;

import static org.assertj.core.api.Assertions.*;

public class SingletonWithPrototypeTeest1 {
    @Test
    void prototypeFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ProtoTypeBean.class);

        ProtoTypeBean prototypeBean1 = ac.getBean(ProtoTypeBean.class);
        ProtoTypeBean prototypeBean2 = ac.getBean(ProtoTypeBean.class);

        prototypeBean1.addCount();
        prototypeBean2.addCount();

        assertThat(prototypeBean1.getCount()).isEqualTo(1);
        assertThat(prototypeBean2.getCount()).isEqualTo(1);
    }

    @Test
    void singletonClientUseProtoType() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(ClientBean.class, ProtoTypeBean.class);

        ClientBean clientBean1 = ac.getBean(ClientBean.class);
        ClientBean clientBean2 = ac.getBean(ClientBean.class);

        int count1 = clientBean1.logic();
        assertThat(count1).isEqualTo(1);

        int count2 = clientBean2.logic();
        assertThat(count2).isEqualTo(1); // 기존에 카운트된 객체를 기억하고 저장
    }
    @Test
    void singletonCountTest(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonTest.SingletonBean.class);
        SingletonTest.SingletonBean singletonBean1 = ac.getBean(SingletonTest.SingletonBean.class);

        singletonBean1.addCount();
        int count1 = singletonBean1.getCount();
        assertThat(count1).isEqualTo(1);

        singletonBean1.addCount();
        int count2 = singletonBean1.getCount();
        assertThat(count2).isEqualTo(2);
    }

    @Scope("singleton")
    @RequiredArgsConstructor
    static class ClientBean {
        @Autowired
        private Provider<ProtoTypeBean> protoTypeBeanProvider;
        public int logic() {
            ProtoTypeBean protoTypeBean = protoTypeBeanProvider.get();
            protoTypeBean.addCount();
            return protoTypeBean.getCount();
        }
    }

    @Scope("prototype")
    static class ProtoTypeBean {
        private int count = 0;

        public void addCount() {
            count++;
        }

        public int getCount() {
            return count;
        }

        @PostConstruct
        public void init() {
            System.out.println("PrototypeBean.init" + this);
        }

        @PreDestroy
        public void destory() {
            System.out.println("PrototypeBean.destory" + this);
        }
    }
}
