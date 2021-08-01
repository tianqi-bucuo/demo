package 反射.静态代理;

//客户
public class Client {
    public static void main(String[] args) {
        //房东
        Host host = new Host();
        //代理(中介)
        MyProxy proxy = new MyProxy(host);
        proxy.rent();
    }
}
