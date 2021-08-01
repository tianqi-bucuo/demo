package SE.枚举;

public class Test {
    public static void main(String[] args) {
        Size size = Size.SMALL;
        switch (size){
            case BIG:
                System.out.println(Size.BIG);
                break;
            case SMALL:
                System.out.println(Size.SMALL);
                break;
            case MIDDLE:
                System.out.println(Size.MIDDLE);
                break;
        }
    }
}
