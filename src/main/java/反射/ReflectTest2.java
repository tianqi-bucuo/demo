package 反射;

import java.lang.reflect.Constructor;

public class ReflectTest2 {
    public static void main(String[] args) throws Exception {

        Class c = Class.forName("反射.Person");
        //使用class文件对象,获取类中的构造方法
        //  Constructor[]  getConstructors() 获取class文件对象中的所有公共的构造方法
		/*Constructor[] cons = c.getConstructors();
		for(Constructor con : cons){
			System.out.println(con);
		}*/
        //获取指定的构造方法,空参数的构造方法
        Constructor con =  c.getConstructor();
        //运行空参数构造方法,Constructor类方法 newInstance()运行获取到的构造方法
        Object obj = con.newInstance();
        System.out.println(obj.toString());
    }
}
