package xchunzhao.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * Resource��spring�ڲ���λ��Դ�Ľӿ�
 * Created by CoderZhao on 2015/11/9.
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
