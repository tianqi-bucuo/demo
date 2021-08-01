package 反射.动态代理;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyFactory proxyFactory = new ProxyFactory();
        //设置被代理对象
        proxyFactory.setProxied(host);
        Rent proxy = (Rent) proxyFactory.getProxy();
        proxy.rent();
    }
}
