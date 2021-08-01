package jvm;

public class LocalVariablesTest {
    int count1 = 0;
    int count2 = 0;
    public LocalVariablesTest(){
        this.count1 = 1;
        this.count2 = 2;
    }
    public void test1(){
        this.count1++;
    }
    public void test2(){
        this.count2++;
    }

    public static void main(String[] args) {
        LocalVariablesTest test = new LocalVariablesTest();
        test.test1();
        test.test2();
    }
}
