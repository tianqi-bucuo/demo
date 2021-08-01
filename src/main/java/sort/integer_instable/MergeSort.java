package sort.integer_instable;

import org.junit.Test;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {
    public void mergerSort(int arr[], int l, int r){
        if (l < r){
            int mid = (l + r) / 2;
            mergerSort(arr, l, mid);
            mergerSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    // 合并两个有序数组
    private void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1;
        int k = 0;

        // 直到其中某个数组被全部合并
        while (i <= mid && j <= r){
            if (arr[i] < arr[j]){
                temp[k++] = arr[i++];
            }else {
                temp[k++] = arr[j++];
            }
        }

        // 把左边剩余的数移入数组
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        // 把右边边剩余的数移入数组
        while(j<=r){
            temp[k++] = arr[j++];
        }
        // 把临时数组中的数赋给arr
        for(int index = 0; index < temp.length; index++){
            arr[l + index] = temp[index];
        }
    }

    @Test
    public void test(){
        int[] arr = {2,5,1,5,8,4,6,8,23,45,65,76,45,3435,567};
        mergerSort(arr, 0, 14);
        System.out.println(Arrays.toString(arr));
    }

}
