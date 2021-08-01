package myCode.algorithms;

public class Singleton {
    private static Singleton instance = new Singleton();
    private Singleton(){}

    public static Singleton getSingleton() {
        return instance;
    }
}
