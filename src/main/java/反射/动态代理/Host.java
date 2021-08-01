package 反射.动态代理;

//房东
public class Host implements Rent{
    //房东只管出租房子
    @Override
    public void rent() {
        System.out.println("房东出租房子");
    }
}
