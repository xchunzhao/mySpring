package xchunzhao;

import org.junit.Test;
import xchunzhao.factory.AutowireCapableBeanFactory;
import xchunzhao.factory.BeanFactory;

/**
 * Created by CoderZhao on 2015/11/6.
 */

public class BeanFactoryTest {
    @Test
    public void test() throws Exception{
        //初始化工厂
        BeanFactory beanFactory=new AutowireCapableBeanFactory();

        //定义Bean
        BeanDefinition beanDefinition=new BeanDefinition();
        beanDefinition.setBeanClassName("xchunzhao.HelloWorld");

        //注册bean(已通过反射拿到bean)
        beanFactory.registerBeanDefinition("helloWorld", beanDefinition);

        //获取实例
        HelloWorld helloWorld= (HelloWorld) beanFactory.getBean("helloWorld");

    }
}
