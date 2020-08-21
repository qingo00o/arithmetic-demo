package com.study.arithmetic.chapter11_sorts2;

/**
 * @ClassName QuickSort
 * @Description 快速排序
 * 快速排序的思想：如果要排序数组中从p到r之间的数据，我们选择P到r之间的任意一个数据作为pivot（分区点）
 * 我们遍历 p 到 r 之间的数据,将小于 pivot 的放到左边,将大于 pivot 的放到右边,将 pivot 放到中间。
 * 经过这一步骤之后,数组 p 到 r 之间的数据就被分成了三个部分，前面 p 到 q-1 之间都是小于 pivot 的,
 * 中间是 pivot,后面的 q 1 到 r 之间是大于pivot的
 @Author DuJian
 * @Date 2019/7/12 16:47
 **/
public class QuickSort {

    public static void quickSortInternally(int[] array ,int p,int r){
        if (p>=r) return;
        int q=partition(array,p,r);
        quickSortInternally(array,p,q);
        quickSortInternally(array,q+1,r);
    }

    /**
     * @Description //获取分区点,每次都使用数组末尾的元素作为分区点
     * @Param [array, p, r]
     * @Return int
     **/
    private static int partition(int[] array, int p, int r) {
        int pivot = array[r];
        int i = p;
        for (int j=p;j<r;++j){
            if (array[j]>pivot){
                for (int k=j;k<r;k++){
                    array[k]=array[k+1];
                }
                array[r]=array[j];
            }
        }
        return -1;
    }
}
