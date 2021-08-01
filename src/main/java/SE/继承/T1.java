package SE.继承;

/**
 * 1.首先，初始化父类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化； 
 *
 * 2.然后，初始化子类中的静态成员变量和静态代码块，按照在程序中出现的顺序初始化； 
 *
 * 3.其次，初始化父类的普通成员变量和代码块，在执行父类的构造方法；
 *
 * 4.最后，初始化子类的普通成员变量和代码块，在执行子类的构造方法； 
 *
 * 注：如果在子类构造器中没有用super明确指定调用父类哪个构造方法，默认调用无参构造
 *
 */
public class T1 {
    public static void main(String[] args) {
        B b = new B("b");
    }
}
class A{
    public A(){
        System.out.println("A");
    }
    public A(String s){
        System.out.println(s);
    }
}

class B extends A{
    public B(String s){
        //如果不用super指定，默认调用父类的无参构造方法
        // super(s);
        System.out.println(s);
    }
}
