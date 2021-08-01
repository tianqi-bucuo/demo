package algorithms;
//最大子数组问题
public class Maximum_subarray{
    public static void main(String[] args) {
        int[] arr = {-29,5,-2,7,9,6,3,-98,12,45,-18,87,-546};
        int[] a = find_maximum_subarray(arr, 0, 12);
        for(int i:a){
            System.out.println(i);
        }
    }
    //寻找跨越中点的最大子数组方法
    private static int[] find_max_crossing_subarray(int[] A,int low,int mid,int high){
        int left_sum = -999;
        int right_sum = -999;
        int left = 0;
        int right = 0;
        int sum = 0;
        for(int i=mid;i >= low;i--){
            sum = sum+A[i];
            if(sum > left_sum){
                left_sum = sum;
                left = i;
            }
        }
        sum = 0;
        for(int j = mid+1;j <= high;j++){
            sum = sum + A[j];
            if(sum > right_sum){
                right_sum = sum;
                right = j;
            }
        }
        int[] result = {left, right, left_sum+right_sum};
        return result;
    }
    private static int[] find_maximum_subarray(int[] A, int low, int high){
        int[] result = new int[3];  //存放结果的数组
        int[] left_result;  //存放左子数组的最大子数组
        int[] right_result; //存放右子数组的最大子数组
        int[] cross_result; //存放跨越中点的最大子数组
        if (low == high){   //数组中只有一个元素的情况，直接返回
            result[0] = low;
            result[1] = high;
            result[2] = A[low];
            return result;
        }else {
            int mid = (low+high)/2;
            left_result = find_maximum_subarray(A, low, mid);   //递归求左子数组的最大子数组
            right_result = find_maximum_subarray(A, mid+1, high);   //递归求右子数组的最大子数组
            //求本层中跨越中点的最大子数组，从此行开始进行合并工作
            cross_result = find_max_crossing_subarray(A, low, mid, high);
            if (left_result[2] >= right_result[2] && left_result[2] >= cross_result[2]){
                return left_result;
            }else if (right_result[2] >= left_result[2] && right_result[2] >= cross_result[2] ){
                return right_result;
            }else {
                return cross_result;
            }
        }
    }
}