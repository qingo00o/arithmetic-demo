package com.study.arithmetic.demopackage;

import java.util.Arrays;

/**
 * 类名称: SearchDemo
 * *********************************
 * 类描述: 查找元素
 *
 * @author DuJian
 * @date 2020/8/21
 **/
public class SearchDemo {

    /**
     * 顺序查找
     * @param a 数组
     * @param key 待查找关键字
     * @return 关键字下标
     */
    public static int sequentialSearch(int[] a, int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }

    /**
     * 有哨兵顺序查找
     * @param a 数组(下标为0存放哨兵元素)
     * @param key 待查询关键字
     * @return 关键字下标 返回0 则未找到
     */
    public static int sequentialSearch2(int[] a, int key) {
        int index = a.length - 1;
        a[0] = key;// 将下标为0的数组元素设置为哨兵
        while (a[index] != key) {
            index--;
        }
        return index;
    }

    /**
     * 二分法查找
     * @param a 数组
     * @param key 待查找关键字
     * @return 返回折半下标， -1表示不存在该关键字
     */
    public static int binarySearch(int[] a, int key) {
        int low, mid, high;
        low = 0;// 最小下标
        high = a.length - 1;// 最大小标
        while (low <= high) {
            mid = (high + low) / 2;// 折半下标
            if (key > a[mid]) {
                low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
            } else if (key < a[mid]) {
                high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
            } else {
                return mid; // 当 key == a[mid] 返回 折半下标
            }
        }
        return -1;
    }



    /**
     * 使用二分查找第一个值等于给定值的位置
     * @param a
     * @param n
     * @param value
     * @date 2020/8/21
     * @author DuJian
     **/
    public int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个大于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @date 2020/8/21
     * @author DuJian
     **/
    public int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] != value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     * @param a
     * @param n
     * @param value
     * @date 2020/8/21
     * @author DuJian
     **/
    public int bsearch7(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else {
                if ((mid == n - 1) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }
    /**
     * 插值查找
     *
     * @param a
     *            数组
     * @param key
     *            待查找关键字
     * @return 返回折半下标， -1表示不存在该关键字
     */
    public static int interpolationSearch(int[] a, int key) {
        int low, mid, high;
        low = 0;// 最小下标
        high = a.length - 1;// 最大小标
        while (low < high) {
            mid = low + (high - low) * (key - a[low]) / (a[high] - a[low]);
            // mid = (high + low) / 2;// 折半下标
            if (key > a[mid]) {
                low = mid + 1; // 关键字比 折半值 大，则最小下标 调成 折半下标的下一位
            } else if (key < a[mid]) {
                high = mid - 1;// 关键字比 折半值 小，则最大下标 调成 折半下标的前一位
            } else {
                return mid; // 当 key == a[mid] 返回 折半下标
            }
        }
        return -1;
    }

    /** 斐波那契数列 */
    static int[] f = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 };

    /**
     * 斐波那契查找(黄金分割原理)
     *
     * @param a
     *            待查询数组
     * @param key
     *            待查找关键字
     * @return 返回关键字在a数组中的下标，返回-1表示数组中不存在此关键字
     */
    public static int fibonaciSearch(int[] a, int key) {
        int low, mid, high, k;
        low = 0;
        high = a.length - 1;
        // 斐波那契数列下标
        k = 0;
        // 获取斐波那契分割值下标
        while (high > f[k] - 1)
            k++;
        // 利用Java工具类Arrays构造长度为f[k]的新数组并指向引用a
        a = Arrays.copyOf(a, f[k]);
        // 对新数组后面多余的元素赋值最大的元素
        for (int i = high + 1; i < f[k]; i++) {
            a[i] = a[high];//当key是是最大值时候，防止角标越界异常
        }
        while (low <= high) {
            // 前半部分有f[k-1]个元素，由于下标从0开始
            // 减去 1 获取 分割位置元素的下标
            mid = low + f[k - 1] - 1;

            if (key < a[mid]) {// 关键字小于分割位置元素，则继续查找前半部分，高位指针移动
                high = mid - 1;
                // (全部元素) = (前半部分)+(后半部分)
                // f[k] = f[k-1] + f[k-2]
                // 因为前半部分有f[k-1]个元素， 则继续拆分f[k-1] = f[k-2] + f[k-3]成立
                // 即在f[k-1]个元素的前半部分f[k-2]中继续查找，所以k = k - 1,
                // 则下次循环mid = low + f[k - 1 - 1] - 1;
                k = k - 1;
            } else if (key > a[mid]) {// 关键字大于分割位置元素，则查找后半部分，低位指针移动
                low = mid + 1;
                // (全部元素) = (前半部分)+(后半部分)
                // f[k] = f[k-1] + f[k-2]
                // 因为后半部分有f[k-2]个元素， 则继续拆分f[k-2] = f[k-3] + f[k-4]成立
                // 即在f[k-2]个元素的前半部分f[k-3]继续查找，所以k = k - 2,
                // 则下次循环mid = low + f[k - 2 - 1] - 1;
                k = k - 2;
            } else {
                // 当条件成立的时候，则找到元素
                if (mid <= high)
                    return mid;
                else
                    // 出现这种情况是查找到补充的元素
                    // 而补充的元素与high位置的元素一样
                    return high;
            }
        }
        return -1;
    }
}
