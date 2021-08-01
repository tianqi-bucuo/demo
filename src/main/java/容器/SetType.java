package 容器;

public class SetType {
    int i;
    public SetType(int n){
        this.i = n;
    }

    @Override
    public boolean equals(Object o) {
        return true;
    }

    @Override
    public int hashCode() {
        return i;
    }
}
