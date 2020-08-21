package com.study.arithmetic.chapter11_sorts2;

/**
 * @ClassName MergeSortTest
 * @Description 归并排序
 * @Author DuJian
 * @Date 2019/7/12 10:28
 **/
public class MergeSortTest {

    public static void mergeSortInternally(int[] array,int p,int r){
        if (p >=r) return;
        int q=p + (r-p)/2;
        //分治递归
        mergeSortInternally(array,p,q);
        mergeSortInternally(array,q+1,r);
        merge(array,p,q,r);
    }

    /**
     * @Description //合并数组
     * @Param [array, p, q, r]
     * @Return void
     **/
    private static void merge(int[] array, int p,int q, int r) {
        int[] tem = new int[r-p+1];
        int i = p,j = q;
        int k = 0;
        while(i<=q && j<=r){
            if (array[i]<=array[j]){
                tem[k++]=array[i++];
            }else{
                tem[k++]=array[j++];
            }
        }
        //判断哪个数组中有剩余的额数据
        int start = i;
        int end = q;
        if (j<=r){
            start = j;
            end = r;
        }
        while (start <=end){
            tem[k++] = array[start];
        }
        // 将tmp中的数组拷贝回a[p...r]
        for (int s=0;s<tem.length;s++){
            array[p+i] = tem[s];
        }
    }

    /**
     * @Description //利用哨兵简化合并的代码
     * @Param [arr, p, q, r]
     * @Return void
     **/
    public static void mergeBySentry(int[] arr, int p, int q, int r) {
        //定义两个临时数组，将两个临时数组的最后一位置为Integer最大值
        int[] leftArray = new int[q-p+2];
        for (int i=0 ;i<=q-p;i++){
            leftArray[i] = arr[i+p];
        }
        leftArray[q-p+1] = Integer.MAX_VALUE;
        int[] rightArray = new int[r-q+1];
        for (int i=0 ;i<r-q;i++){
            rightArray[i] = arr[i+q];
        }
        rightArray[r-q] = Integer.MAX_VALUE;
        int i=0,j=0;
        int k=p;
        while (k<=r){
            //当其中一个数组的游标到了末尾，也就是Integer的最大值那里，便不再继续往前，转而执行另一个的数组的游标
            if (leftArray[i]<=rightArray[j]){
                arr[k++] = leftArray[i++];
            }else{
                arr[k++] = rightArray[j++];
            }
        }
    }

}
