package com.objcat.playground.hdoj;

public class HDOJ1097 {
    /*
    lcy gives a hard puzzle to feng5166,lwg,JGShining and Ignatius: gave a and b,how to know the a^b.everybody objects to this BT problem,so lcy makes the problem easier than begin.
    this puzzle describes that: gave a and b,how to know the a^b's the last digit number.But everybody is too lazy to slove this problem,so they remit to you who is wise.

    lcy给了feng5166,lwg,JGShining和Ignatius一个难题:给出了a和b，如何知道a^b。每个人都反对这个BT问题，所以lcy使这个问题比开始容易。
    这个谜题描述的是:给定a和b，如何知道a^b的最后一位数。但每个人都懒得解决这个问题，所以他们向你请教谁是明智的。

    Sample Input
    7 66
    8 800

    Sample Output
    9
    6
     */

    public static void main(String[] args) {
        String result = xor(7, 66);
        String result2 = xor(8, 800);
        System.out.println(result);
        System.out.println(result2);
    }

    static String xor(int a, int b) {
        String str = (a ^ b) + "";
        System.out.println(str);
        return str.substring(str.length() - 1);
    }

}
