package 反射.动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactory implements InvocationHandler {

    //被代理对象，将类型设为Object,可代理任何类型
    private Object proxied;

    public void setProxied(Object proxied){
        this.proxied = proxied;
    }

    //生成代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                proxied.getClass().getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object res = method.invoke(proxied, args);
        //在原来租房的基础上加强的方法
        log(method.getName());
        return res;
    }

    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }
}
