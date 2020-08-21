package com.study.arithmetic.demopackage;

import java.util.ArrayList;
import java.util.List;

/**
 * 类名称: PrimeNumber
 * *********************************
 * 类描述: 求质数
 *
 * @author DuJian
 * @date 2020/8/21
 **/
public class PrimeNumber {

    public static void main(String[] args) {
        /*List<Integer> primes = getPrimes(100);
        primes.forEach(System.out::println);*/
        int i = countPrimes(150);
        System.out.println(i);

    }


    /**
     * 求 n 以内的所有素数
     * @param n 范围
     * @return n 以内的所有素数
     */
    private static List<Integer> getPrimes(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(2);
        for (int i = 3; i <= n; i += 2) {
            if (!divisible(i, result)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * 判断 n 是否能被整除
     * @param n   要判断的数字
     * @param primes 素数列表
     * @return 如果 n 能被 primes 中任何一个整除，则返回 true。
     */
    private static boolean divisible(int n, List<Integer> primes) {
        for (Integer prime : primes) {
            if (n % prime == 0) {
                return true;
            }
        }
        return false;
    }


    /**
     * 判断一个数是不是素数
     * @param num
     * @date 2020/8/21
     * @author DuJian
     **/
    public boolean isPrimeNumber(int num){
        if(num == 2) return true;
        if(num < 2 || num % 2 == 0) return false;
        //这里直接循环到num的平方根，因为一个数如果是合数，那么它一定可以由两个自然数相乘得到，
        // 这两个数其中一个一定小于或等于num的开放根
        for(int i=3; i<=Math.sqrt(num); i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }


    /**
     * 计算一个数之内素数的s数量（参考leetcode上的解法）
     * 厄拉多塞筛法
     * @param n
     * @date 2020/8/21
     * @author DuJian
     **/
    public static int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }

        boolean[] sign = new boolean[n];
        // 从 3 开始遍历，只遍历奇数
        for (int i = 3; i <= n / i; i += 2) {
            if (!sign[i]) {
                // 将当前质数的奇数倍都设置成非质数标记 true
                // n 不会很大，所以不用担心越界
                for (int j = i; i * j < n; j += 2) {
                    sign[i * j] = true;
                }
            }
        }

        int count = 1;
        for (int i = 3; i < n; i += 2) {
            if (!sign[i]) {
                count++;
            }
        }
        return count;
    }

}
