package com.yx.training;

/**
 * Created by 欣 on 2015/4/27 0027.
 * 风口之下，猪都能飞。当今中国股市牛市，真可谓“错过等七年”。
 * 给你一个回顾历史的机会，已知一支股票连续n天的价格走势，
 * 以长度为n的整数数组表示，数组中第i个元素（prices[i]）代表该股票第i天的股价。
 * 假设你一开始没有股票，但有至多两次买入1股而后卖出1股的机会，
 * 并且买入前一定要先保证手上没有股票。若两次交易机会都放弃，收益为0。
 * 设计算法，计算你能获得的最大收益。 输入数值范围：2<=n<=100,0<=prices[i]<=100
 * 输入例子:
 * 3,8,5,1,7,8
 * 输出例子:
 * 12
 */
public class Test1 {

    public static void main(String[] args) {
        int[] tem = {3, 8, 5, 1, 7, 8};
        int maxmax = 0;
        for (int j = 0; j < tem.length; ++j) {
            int maxTem = 0;
            if (j == 0 || j == 1) {
                maxTem = maxInt(tem, j, tem.length - 1);
            } else if (j == tem.length - 1) {
                maxTem = maxInt(tem, 0, tem.length - 2);
            } else {
                maxTem = maxInt(tem, 0, j - 1) + maxInt(tem, j, tem.length - 1);
            }
            maxmax = maxTem > maxmax ? maxTem : maxmax;
        }
        System.out.println(maxmax);
    }

    private static int maxInt(int[] input, int s, int e) {
        if (s == e) {
            return 0;
        }
        if (e - s == 1) {
            return input[e] - input[s];
        }
        int max = 0;
        for (int i = e; i > s; i--) {
            for (int k = i - 1; k >= s; k--) {
                max = input[i] - input[k] > max ? input[i] - input[k] : max;
            }
        }
        return max < 0 ? 0 : max;
    }
}