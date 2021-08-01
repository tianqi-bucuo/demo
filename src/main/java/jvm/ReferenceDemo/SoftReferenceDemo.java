package jvm.ReferenceDemo;

public class SoftReference {
    public static void main(String[] args) {
        SoftReference<byte[]> m = new SoftReference(new byte[]);
    }
}
