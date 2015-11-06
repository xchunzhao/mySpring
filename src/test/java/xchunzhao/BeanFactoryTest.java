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
        //��ʼ������
        BeanFactory beanFactory=new AutowireCapableBeanFactory();

        //����Bean
        BeanDefinition beanDefinition=new BeanDefinition();
        beanDefinition.setBeanClassName("xchunzhao.HelloWorld");

        //ע��bean(��ͨ�������õ�bean)
        beanFactory.registerBeanDefinition("helloWorld", beanDefinition);

        //��ȡʵ��
        HelloWorld helloWorld= (HelloWorld) beanFactory.getBean("helloWorld");

    }
}
