package SE.泛型;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //上界
        //不能add
        //可以get,返回值是Apple类型
        List<? extends Apple> list1 = Arrays.asList(new Apple(),new Jonathan());
        //编译报错
        //list1.add(new Apple());
        Apple apple1 = list1.get(0);
        Apple apple2 = list1.get(1);

        //下界
        //可以add,add的类型必须是Apple或其子类
        //可以get,返回值是Object类型
        List<? super Apple> list2 = new ArrayList<>();
        list2.add(new Apple());
        list2.add(new Jonathan());
        //编译报错
        //list2.add(new Fruit());
        //get
        Object object = list2.get(0);

        //无界
        //不能add
        //可以get,返回值是Object类型
        List<?> list3 = Arrays.asList(new Apple());
        //编译报错
        //list3.add(new Apple());
        //list3.add(new Object());
        Object o = list3.get(0);
    }
}


