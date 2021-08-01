package io.streamDemo;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamTest1 {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("F:\\a.txt");
        //流对象的方法write写数据
        //写1个字节
        fos.write(97);

        //写字节数组
        byte[] bytes = {65, 66, 67, 68};
        fos.write(bytes);

        //写字节数组的一部分,开始索引,写几个
        fos.write(bytes, 1, 2);

        //写入字节数组的简便方式
        //写字符串
        fos.write("hello".getBytes());

        //关闭资源
        fos.close();

    }

    @Test
    public void test(){
        FileOutputStream out = null;

        try {
            out = new FileOutputStream("F:\\b.txt");

            // 写入单个字节
            out.write(97);

            // 写入字节数组
            byte[] bytes = {67, 68, 69, 70};
            out.write(bytes);

            out.write("hello".getBytes());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
