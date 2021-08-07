package jvm.ReferenceDemo;

public class NormalReferenceDemo {
    public static void main(String[] args) {
        M m = new M();
        m = null;
        System.gc();
    }
}
