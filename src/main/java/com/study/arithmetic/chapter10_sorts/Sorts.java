package com.study.arithmetic.chapter10_sorts;

/**
 * 冒泡排序
 * @date 2020/8/21
 * @author DuJian
 **/
public class Sorts {
    public static void main(String[] args) {
        int[] a = {2,9,8,4,8,13,5,7,1};
        selectionSort(a);
        for (int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }

    /**
     * @Description //冒泡排序
     * @Param [array]
     **/
    public static void bubbleSort(int[] array){
        for (int i=0;i<array.length;i++){
            boolean flag = false;
            for (int j=0;j<array.length-i-1;j++){
                if (array[j]>array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;   //如果没有数据交换，直接退出循环
        }
    }

    /**
     * @Description //插入排序
     * 首先，我们将数组中的数据分为两个区间，已排序区间和未排序区间。初始已排序区间只有一个元素，
     * 就是数组的第一个元素。插入算法的核心思想是取未排序区间中的元素，在已排序区间中找到合适的
     * 插入位置将其插入，并保证已排序区间数据一直有序。重复这个过程，直到未排序区间中元素为空，算法结束。
     * @Param [array]
     **/
    public static void insertionSort(int[] array){
        if (array.length<=1){
            return;
        }
        for (int i=1;i< array.length;++i){
            int value = array[i];
            int j = i-1;
            for (;j>=0;--j){
                if (array[j]>value){
                    array[j+1] = array[j]; //数据移动
                }else{
                    break;
                }
            }
            array[j+1] = value;//插入数据
        }

    }

    /**
     * @Description //选择排序
     * 选择排序算法的实现思路有点类似插入排序，也分已排序区间和未排序区间。
     * 但是选择排序每次会从未排序区间中找到最小的元素，将其放到已排序区间的末尾。
     * @Param [array]
     **/
    public static void selectionSort(int[] array){
        if (array.length <= 1) return;
        for (int i=0;i<array.length;i++){
            int index = i;
            for (int j=i;j<array.length-1;j++){
                if (array[j+1]<array[index]){
                    index = j+1;
                }
            }
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }
}
