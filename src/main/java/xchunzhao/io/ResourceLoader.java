package xchunzhao.io;

import java.net.URL;

/**
 * Created by CoderZhao on 2015/11/9.
 */
public class ResourceLoader {
    public  Resource getResource(String location){
        URL resource=this.getClass().getClassLoader().getResource(location);
        return new UrlResource(resource);
    }
}
