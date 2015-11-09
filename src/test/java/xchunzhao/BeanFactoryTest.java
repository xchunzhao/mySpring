package xchunzhao;

import org.junit.Test;
import xchunzhao.factory.AutowireCapableBeanFactory;
import xchunzhao.factory.BeanFactory;
import xchunzhao.io.ResourceLoader;
import xchunzhao.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * Created by CoderZhao on 2015/11/6.
 */

public class BeanFactoryTest {
    @Test
    public void test() throws Exception{
//        //��ʼ������
//        BeanFactory beanFactory=new AutowireCapableBeanFactory();
//
//        //����Bean
//        BeanDefinition beanDefinition=new BeanDefinition();
//        beanDefinition.setBeanClassName("xchunzhao.HelloWorld");
//
//        //װ������
//        PropertyValues propertyValues=new PropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("name","xchunzhao"));
//        beanDefinition.setPropertyValues(propertyValues);
//
//        //ע��bean(��ͨ�������õ�bean)
//        beanFactory.registerBeanDefinition("helloWorld", beanDefinition);
//
//
//        //��ȡʵ��
//        HelloWorld helloWorld= (HelloWorld) beanFactory.getBean("helloWorld");
//        helloWorld.helloWorld();
        // 1.��ȡ����
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("mySpring.xml");
        System.out.print(xmlBeanDefinitionReader.getRegistry());

        // 2.��ʼ��BeanFactory��ע��bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.��ȡbean
        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("HelloWorld");
        helloWorld.helloWorld();
    }
}
