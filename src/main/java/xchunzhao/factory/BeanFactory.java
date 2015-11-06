package xchunzhao.factory;

import xchunzhao.BeanDefinition;

/**
 * Created by CoderZhao on 2015/11/6.
 * bean���� �ṩ��ȡ��ע��bean�ķ���
 */
public interface BeanFactory {
    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
