package xchunzhao.xml;

import org.junit.Assert;
import org.junit.Test;
import xchunzhao.BeanDefinition;
import xchunzhao.io.ResourceLoader;

import java.util.Map;

/**
 * Created by CoderZhao on 2015/11/9.
 */
public class XmlBeanDefinitionReaderTest {
    @Test
    public void test() throws Exception {
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("mySpring.xml");
        Map<String, BeanDefinition> registry = xmlBeanDefinitionReader.getRegistry();
        System.out.println(registry);
        Assert.assertTrue(registry.size() > 0);
    }
}
