package xchunzhao.factory;

import xchunzhao.BeanDefinition;

/**
 * Created by CoderZhao on 2015/11/6.
 */
public class AutowireCapableBeanFactory extends AbstractBeanFactory {
    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean=createBeanInstance(beanDefinition);
        return null;
    }

    /**
     * ͨ�������ȡbeanʵ��
     * @param beanDefinition
     * @return
     * @throws Exception
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception{
        return beanDefinition.getBeanClass().newInstance();
    }
}
