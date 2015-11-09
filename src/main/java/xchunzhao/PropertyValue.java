package xchunzhao;

/**
 * Created by CoderZhao on 2015/11/6.
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, String value) {
        this.name=name;
        this.value=value;
    }

    public Object getValue() {
        return value;
    }


    public String getName() {
        return name;
    }

}
