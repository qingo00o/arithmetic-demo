package com.study.arithmetic.chapter11_sorts2;


/**
 * @ClassName MergeSort
 * @Description 歸并排序
 * @Author DuJian
 * @Date 2019/7/10 14:59
 **/
public class MergeSort {

    public static void main(String[] args) {
        int[] a={2,9,8,4,8,13,5,7,1};
        merge_sort(a,9);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    public static void merge_sort(int[] array , int len){
        merge_sort_c(array,0,len-1);
    }

    /**
     * @Description //归并排序的递归调用函数，p和r分别表示排序开始与结束的下标
     * @Param [array, p, r]
     * @Return void
     **/
    public static void merge_sort_c(int[] array,int p,int r){
        //递归终止条件
        if(p>=r) return;
        int q = p + (r-p)/2;
        //分治递归
        merge_sort_c(array,p,q);
        merge_sort_c(array,q+1,r);
        // 将A[p...q]和A[q+1...r]合并为A[p...r]
        merge(array, p, q, r);
    }

    private static void merge(int[] a, int p, int q, int r) {
        int i = p;
        int j = q+1;
        int k = 0; // 初始化变量i, j, k
        int[] tmp = new int[r-p+1]; // 申请一个大小跟a[p...r]一样的临时数组
        while (i<=q && j<=r) {
            if (a[i] <= a[j]) {
                tmp[k++] = a[i++]; // i++等于i:=i+1
            } else {
                tmp[k++] = a[j++];
            }
        }
        // 判断哪个子数组中有剩余的数据
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        // 将剩余的数据拷贝到临时数组tmp
        while (start <= end) {
            tmp[k++] = a[start++];
        }

        // 将tmp中的数组拷贝回a[p...r]
        for (i = 0; i <= r-p; ++i) {
            a[p+i] = tmp[i];
        }
    }
}
