package io.streamDemo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Copy3 {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try{
            fr = new FileReader("c:\\1.txt");
            fw = new FileWriter("d:\\1.txt");
            char[] buf = new char[1024];
            int len;
            while(( len = fr.read(buf))!=-1){
                fw.write(buf, 0, len);
                fw.flush();
            }

        }catch(IOException ex){
            System.out.println(ex);
            throw new RuntimeException("复制失败");
        }finally{
            try{
                if(fw!=null)
                    fw.close();
            }catch(IOException ex){
                throw new RuntimeException("释放资源失败");
            }finally{
                try{
                    if(fr!=null)
                        fr.close();
                }catch(IOException ex){
                    throw new RuntimeException("释放资源失败");
                }
            }
        }
    }
}
