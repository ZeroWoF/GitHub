package com.yx.training;

/**
 * Created by 欣 on 2015/4/27 0027.
 * 包装类型 对象创建规则
 */
public class Test2 {

    public static void main(String[] args) {
        // 常量缓冲池
        Integer i01 = 59;

        // 常量缓冲池
        int i02 = 59;

        // -128 - 127 常量缓冲池 否则 新建对象
        Integer i03 = Integer.valueOf(59);

        // 新建对象
        Integer i04 = new Integer(59);

        System.out.println("i01 == i02 " + (i01 == i02));
        System.out.println("i01 == i03 " + (i01 == i03));
        System.out.println("i01 == i04 " + (i01 == i04));
        System.out.println("i02 == i03 " + (i02 == i03));
        System.out.println("i02 == i04 " + (i02 == i04));
        System.out.println("i03 == i04 " + (i03 == i04));

        String a = "a";
        String b = String.valueOf("a");
        String c = new String("a");

        System.out.println(" a == b " + (a == b));
        System.out.println(" a == c " + (a == c));
        System.out.println(" c == b " + (c == b));
    }
}
