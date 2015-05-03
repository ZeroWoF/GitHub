package com.yx.training.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by �� on 2015/4/30 0030.
 * ��֪��������head1��head2��������
 * ������Ǻϲ���һ��������Ȼ����
 * �������Ҫ����head1��head2�����нڵ㣬
 * ��ʹ�ڵ�ֵ��ͬ��
 */
public class LinkListMerger {
    public static void main(String[] argv) {
        List a = new LinkedList<Integer>();
        a.add(20);
        a.add(31);
        a.add(40);
        a.add(50);
        a.add(60);
        List b = new LinkedList<Integer>();
        b.add(20);
        b.add(30);
        b.add(42);

        //1
        List d = new LinkedList();
        d.addAll(a);
        d.addAll(b);
        Collections.sort(d);

        //2
        List e = linkListMerger(a, b);
        for (Object tem : e) {
            System.out.println((Integer) tem);
        }

    }

    public static List linkListMerger(List a, List b) {
        List c = new LinkedList();
        for (int i = 0, j = 0; !(c.size() == a.size() + b.size()); ) {
            if (i >= a.size()) {
                c.add(b.get(j));
                j++;
            } else if (j >= b.size()) {
                c.add(a.get(i));
                i++;
            } else if (((Integer) a.get(i)) > (Integer) b.get(j)) {
                c.add(b.get(j));
                j++;
            } else {
                c.add(a.get(i));
                i++;
            }
        }
        return c;
    }
}
