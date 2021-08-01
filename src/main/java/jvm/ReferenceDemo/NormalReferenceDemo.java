package jvm.ReferenceDemo;

public class NormalReference {
    public static void main(String[] args) {
        M m = new M();
        m = null;
        System.gc();
    }
}
