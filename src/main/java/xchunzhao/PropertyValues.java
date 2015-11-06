package xchunzhao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CoderZhao on 2015/11/6.
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList=new ArrayList<PropertyValue>();

    public PropertyValues(){

    }
    public void addPropertyValue(PropertyValue propertyValue){
        this.propertyValueList.add(propertyValue);
    }

    public List<PropertyValue> getPropertyValueList(){
        return this.propertyValueList;
    }
}
