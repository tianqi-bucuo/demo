package 反射;

import java.lang.reflect.Method;
import java.util.ArrayList;

/*
 *   定义集合类,泛型String
 *   要求向集合中添加Integer类型
 *
 *   反射方式,获取出集合ArrayList类的class文件对象
 *   通过class文件对象,调用add方法
 *
 *   顺便证明一下泛型擦除
 *
 */
public class ReflectTest8 {
    public static void main(String[] args)throws Exception {
        ArrayList<String> array  = new ArrayList<>();
        array.add("a");
        //反射方式,获取出集合ArrayList类的class文件对象
        Class c = array.getClass();
        //获取ArrayList.class文件中的方法add
        Method method = c.getMethod("add",Object.class);
        //使用invoke运行ArrayList方法add
        //泛型擦除，可以添加任何类型数据
        method.invoke(array, 123);
        method.invoke(array, 3.14);
        method.invoke(array, 'a');
        System.out.println(array);
    }
}
