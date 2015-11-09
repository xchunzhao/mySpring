package xchunzhao.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource是spring内部定位资源的接口
 * Created by CoderZhao on 2015/11/9.
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
