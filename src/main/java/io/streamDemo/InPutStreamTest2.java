package io.streamDemo;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InPutStreamTest2 {
    public static void main(String[] args) throws IOException {
        // 读取字节数组
        // 数组作用: 缓冲, 提高效率
        FileInputStream fis = new FileInputStream("F:\\a.txt");
        //创建字节数组
        byte[] b = new byte[1024];

        int len;
        while( (len = fis.read(b)) !=-1){
            System.out.print(new String(b,0,len));
        }
        fis.close();
    }

    @Test
    public void test(){
        try {
            FileInputStream in = new FileInputStream("F:\\a.txt");

            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1){
                System.out.println(new String(bytes, 0, len));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
