package com.yx.training;

/**
 * Created by �� on 2015/4/27 0027.
 * ��װ���� ���󴴽�����
 */
public class Test2 {

    public static void main(String[] args) {
        // ���������
        Integer i01 = 59;

        // ���������
        int i02 = 59;

        // -128 - 127 ��������� ���� �½�����
        Integer i03 = Integer.valueOf(59);

        // �½�����
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
