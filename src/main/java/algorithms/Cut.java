package algorithms;
//动态规划之钢条切割
public class Cut {
    public static void main(String[] args) {
        //钢条价格数组
        int[] p = {1,5,8,9,10,17,17,20,24,30};
        method(p, 10);
    }
    public static void method(int[] p, int n){
        //结果数组
        int[] r = new int[n+1];
        //切割方式数组
        int[] s = new int[n+1];
        for(int j = 1;j <= n;j++){
            int q = -1;     //此处-1的作用是"无穷小"
            for(int i = 1;i <= j;i++){
                if(q < p[i-1]+r[j-i]){
                    q = p[i-1]+r[j-i];
                    s[j] = i;   //表示长度为j时，被切割后的左部分长度为i,而右部分如何切割则递归查找s数组
                    r[j] = q;   //长度为j时的最大收益值
                }
            }
        }
        for (int count = 0;count <= n;count++){
            System.out.println(r[count]);
            System.out.println(s[count]);
        }
    }
}
