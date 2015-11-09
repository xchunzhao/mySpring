package xchunzhao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CoderZhao on 2015/11/6.
 */
public class PropertyValues {
    private  final List<PropertyValue> propertyValueList=new ArrayList<PropertyValue>();

    public PropertyValues(){

    }
    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }

    public List<PropertyValue> getPropertyValueList(){
        return this.propertyValueList;
    }
}
