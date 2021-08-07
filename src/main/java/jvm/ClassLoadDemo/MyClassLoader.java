package jvm.ClassLoadDemo;

import java.io.*;

public class MyClassLoader extends ClassLoader{
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File path = new File("F:/", name.replaceAll("\\.", "/").concat(".class"));
        byte[] bytes=null;
        try {
            InputStream is=new FileInputStream(path);
            ByteArrayOutputStream bos=new ByteArrayOutputStream();
            byte[] buf=new byte[1024];
            int r=0;
            while ((r=is.read(buf))!=-1){
                bos.write(buf,0,r);
            }
            bytes=bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert bytes != null;
        return defineClass(name,bytes,0,bytes.length);
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        // System.out.println(File.separator);

        MyClassLoader loader = new MyClassLoader();
        Class clazz = loader.loadClass("test.Person");
        Object p = clazz.newInstance();
    }
}
