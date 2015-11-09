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
//        //初始化工厂
//        BeanFactory beanFactory=new AutowireCapableBeanFactory();
//
//        //定义Bean
//        BeanDefinition beanDefinition=new BeanDefinition();
//        beanDefinition.setBeanClassName("xchunzhao.HelloWorld");
//
//        //装载属性
//        PropertyValues propertyValues=new PropertyValues();
//        propertyValues.addPropertyValue(new PropertyValue("name","xchunzhao"));
//        beanDefinition.setPropertyValues(propertyValues);
//
//        //注册bean(已通过反射拿到bean)
//        beanFactory.registerBeanDefinition("helloWorld", beanDefinition);
//
//
//        //获取实例
//        HelloWorld helloWorld= (HelloWorld) beanFactory.getBean("helloWorld");
//        helloWorld.helloWorld();
        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("mySpring.xml");
        System.out.print(xmlBeanDefinitionReader.getRegistry());

        // 2.初始化BeanFactory并注册bean
        BeanFactory beanFactory = new AutowireCapableBeanFactory();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        HelloWorld helloWorld = (HelloWorld) beanFactory.getBean("HelloWorld");
        helloWorld.helloWorld();
    }
}
