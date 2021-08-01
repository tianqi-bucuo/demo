package jvm;

public class Test2 {

    public int a = 1;
    public int b = 2;

    public int sum1(){
        int res = a + b;
        return res;
    }

    public static void main(String[] args) {
        LocalVariablesTest localVariablesTest = new LocalVariablesTest();
        if (LocalVariablesTest.class.isInstance(localVariablesTest)){
            System.out.println(1);
        }
    }

}
