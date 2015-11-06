package xchunzhao;

/**
 * Created by CoderZhao on 2015/11/6.
 */
public class PropertyValue {
    private String name;
    private Object value;

    public PropertyValue(String name, String value) {
        this.name=name;
        this.value=value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
