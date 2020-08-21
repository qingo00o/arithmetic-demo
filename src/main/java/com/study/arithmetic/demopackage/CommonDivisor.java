package com.study.arithmetic.demopackage;

/**
 * 类名称: CommonDivisor
 * *********************************
 * 类描述: 最大公约数与最小公倍数
 *
 * @author DuJian
 * @date 2020/8/21
 **/

public class CommonDivisor {
    public static void main(String[] args) {

        int highestConventionNumber = getLowestCommonMultiple(15, 99);
        System.out.println(highestConventionNumber);
    }

    /**
     * 求最大公约数
     * @param m
     * @param n
     * @date 2020/8/21
     * @author DuJian
     **/
    public static int getHighestConventionNumber(int m,int n){
        //辗转相除法
        if(m < n){
            m= m ^ n;
            n= m ^ n;
            m= m ^ n;
        }
        return m % n == 0 ?  n :  getHighestConventionNumber(n, m % n);
    }

    /**
     * 最小公倍数
     * @param m
     * @param n
     * @date 2020/8/21
     * @author DuJian
     **/

    public static int getLowestCommonMultiple(int m, int n){
        // 最小公倍数即为：m*n/最大公约数
        return m * n / getHighestConventionNumber(m,n);
    }

}
