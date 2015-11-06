package xchunzhao.factory;

import xchunzhao.BeanDefinition;
import xchunzhao.PropertyValue;

import java.lang.reflect.Field;

/**
 * Created by CoderZhao on 2015/11/6.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean=createBeanInstance(beanDefinition);
        applyPropertyValues(bean,beanDefinition);
        return bean;
    }

    /**
     * 通过反射装载属性
     * @param bean
     * @param beanDefinition
     * @throws Exception
     */
    protected void applyPropertyValues(Object bean, BeanDefinition beanDefinition) throws Exception{
        for (PropertyValue propertyValue:beanDefinition.getPropertyValues().getPropertyValueList()){
            Field declaredField=bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean,propertyValue.getValue());
        }
    }

    /**
     * 通过反射获取bean实例
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }
}
