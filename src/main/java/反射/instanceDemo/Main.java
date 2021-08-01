package 反射.instanceDemo;

public class Main {
    public static void main(String[] args) {

        A a = new A();
        SubA subA = new SubA();

        if (a instanceof A)
            System.out.println("a instanceof A -> " + true);
        else
            System.out.println("a instanceof A -> " + false);

        if (subA instanceof SubA)
            System.out.println("subA instanceof SubA -> " +true);
        else
            System.out.println("subA instanceof SubA -> " + false);

        if (A.class.isInstance(a))
            System.out.println("A.class.isInstance(a) -> " + true);
        else
            System.out.println("A.class.isInstance(a) -> " + false);

        if (A.class.isInstance(subA))
            System.out.println("A.class.isInstance(subA) -> " + true);
        else
            System.out.println("A.class.isInstance(subA) -> " + false);

    }
}

class A{

}

class SubA{

}
