package io.streamDemo;

import org.junit.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InPutStreamTest1 {
    public static void main(String[] args) throws IOException {
        //read()执行一次,就会自动读取下一个字节
        //返回值,返回的是读取到的字节, 读取到结尾返回-1
        FileInputStream fis = new FileInputStream("F:\\a.txt");
        //读取一个字节,调用方法read 返回int
        //使用循环方式,读取文件,  循环结束的条件  read()方法返回-1
        int cur;// read方法每执行一次就会读取下一个字节，cur用来保存当前字节
        while( (cur = fis.read()) != -1){
            System.out.print((char)(cur));
        }
        //关闭资源
        fis.close();
    }
}
