package xchunzhao.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import xchunzhao.AbstractBeanDefinitionReader;
import xchunzhao.BeanDefinition;
import xchunzhao.PropertyValue;
import xchunzhao.io.ResourceLoader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * 获取资源文件 并解析bean装载bean
 * Created by CoderZhao on 2015/11/9.
 */
public class XmlBeanDefinitionReader extends AbstractBeanDefinitionReader {
    public  XmlBeanDefinitionReader(ResourceLoader resourceLoader) {
        super(resourceLoader);
    }

    public void loadBeanDefinitions(String location) throws Exception {
        InputStream inputStream=getResourceLoader().getResource(location).getInputStream();
        doLoadBeandifinitions(inputStream);
    }

    protected void doLoadBeandifinitions(InputStream inputStream) throws Exception {
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder=factory.newDocumentBuilder();
        Document doc=docBuilder.parse(inputStream);

        registerBeanDefinitions(doc);
        inputStream.close();
    }

    public void registerBeanDefinitions(Document doc) {
        Element root=doc.getDocumentElement();
        parseBeanDefinitions(root);
    }

    protected void parseBeanDefinitions(Element root) {
        NodeList nl=root.getChildNodes();
        for (int i=0;i<nl.getLength();i++){
            Node node=nl.item(i);
            if (node instanceof Element){
                Element ele=(Element)node;
                processBeanDefinition(ele);
            }
        }
    }

    //解析bean
    protected void processBeanDefinition(Element ele) {
        String name=ele.getAttribute("name");
        String className=ele.getAttribute("class");
        BeanDefinition beanDefinition=new BeanDefinition();
        System.out.println(beanDefinition);
        processProperty(ele, beanDefinition);
        beanDefinition.setBeanClassName(className);
        getRegistry().put(name, beanDefinition);
    }

    //装载bean
    private void processProperty(Element ele, BeanDefinition beanDefinition) {
        NodeList propertyNode=ele.getElementsByTagName("property");
        for (int i =0;i<propertyNode.getLength();i++){
            Node node=propertyNode.item(i);
            if (node instanceof Element){
                Element propertyEle=(Element)node;
                String name=propertyEle.getAttribute("name");
                //System.out.println(name);
                String value=propertyEle.getAttribute("value");
                //System.out.println(value);
              //  beanDefinition.getPropertyValues()
                System.out.println(beanDefinition.getPropertyValues());
                beanDefinition.getPropertyValues().addPropertyValue(new PropertyValue(name, value));
            }
        }
    }

}
