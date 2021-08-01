package 反射.静态代理;

//代理
public class MyProxy implements Rent {

    private Host host;

    public MyProxy(Host host){
        this.host = host;
    }
    @Override
    public void rent() {
        seeHouse();
        host.rent();
        agreement();
        charge();
    }

    //在原来租房的基础上加强的方法
    public void seeHouse(){
        System.out.println("中介带你看房");
    }

    public void agreement(){
        System.out.println("中介和你签合同");
    }

    public void charge(){
        System.out.println("中介收费");
    }
}
