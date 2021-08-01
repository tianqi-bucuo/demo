package SE.运算符;

public class Demo1 {
    public static void main(String[] args){
        int a=1;
        int b=3;
        System.out.println("a & b :" + (a & b));
        System.out.println("a | b :" + (a | b));
        System.out.println("a ^ b :" + (a ^ b));
        System.out.println(" ~ a :" + ~ a);
        // <<:左移	左边最高位丢弃，右边补齐0;
        // 如果移动的位数超过了该类型的最大位数，那么编译器会对移动的位数取模
        System.out.println("15 << 2 :" + (15 << 2));
        // >>:右移	最高位是0，左边补齐0；最高为是1，左边补齐1；
        System.out.println("-15 >> 2 :" + (-15 >> 2));
        // >>>:无符号右移 无论最高位是0还是1，左边补齐0；
        System.out.println("15 >>> 2 :" + (15 >>> 2));
    }
}
