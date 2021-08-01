package jvm.memory;

public class Demo1 {
    int i = 0;
    void func() {
        synchronized (this) {
            i++;
        }
    }

    synchronized void c() {
        i++;
    }

    public static void main(String[] args) {

    }
}
