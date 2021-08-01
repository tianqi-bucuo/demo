package io.streamDemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamTest2 {
    public static void main(String[] args)throws IOException {
        File file = new File("F:\\b.txt");
        //如果要在文件末尾追加，参数加上true
        FileOutputStream fos = new FileOutputStream(file,true);
        //换行使用\r\n
        fos.write("hello\r\n".getBytes());
        fos.write("world".getBytes());
        fos.close();
    }
}
