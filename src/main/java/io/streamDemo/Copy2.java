package io.streamDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Copy2 {
    public static void main(String[] args) {
        long s = System.currentTimeMillis();
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("c:\\t.zip");
            fos = new FileOutputStream("d:\\t.zip");
            //定义字节数组,缓冲
            byte[] bytes = new byte[1024*10];
            //读取数组,写入数组
            int len;
            while((len = fis.read(bytes))!=-1){
                fos.write(bytes, 0, len);
            }
        }catch(IOException ex){
            System.out.println(ex);
            throw new RuntimeException("文件复制失败");
        }finally{
            try{
                if(fos!=null)
                    fos.close();
            }catch(IOException ex){
                throw new RuntimeException("释放资源失败");
            }finally{
                try{
                    if(fis!=null)
                        fis.close();
                }catch(IOException ex){
                    throw new RuntimeException("释放资源失败");
                }
            }
        }
        long e = System.currentTimeMillis();
        System.out.println(e-s);
    }
}
