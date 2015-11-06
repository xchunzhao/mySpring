package xchunzhao.factory;

import xchunzhao.BeanDefinition;

/**
 * Created by CoderZhao on 2015/11/6.
 * bean容器 提供获取、注册bean的方法
 */
public interface BeanFactory {
    Object getBean(String name);

    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
