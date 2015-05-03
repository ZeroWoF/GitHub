package com.yx.training.sort;

import java.util.Arrays;

/**
 * Created by 欣 on 2015/5/2 0002.
 */
public class SortTest {
    public static void main(String[] argv) {
        int[] array = {99, 2, 1, 3, 1, 4, 7, 8, 3, 1, 3, 7, 98, -9, -4, 110, 100};
        // 冒泡排序
        //System.out.println("bubbleSort: " + Arrays.toString(bubbleSort(array)));
        // 插入排序 - 直接插入
        //System.out.println("insertSort: " + Arrays.toString(insertSort(array)));
        // 插入排序 - 二分插入
        //System.out.println("binaryInsertSort: " + Arrays.toString(binaryInsertSort(array)));
        // 插入排序 - 希尔排序
        //System.out.println("shellSort: " + Arrays.toString(shellSort(array)));
        // 选择排序 - 直接选择排序
        //System.out.println("selectionSort: " + Arrays.toString(selectionSort(array)));
        // 选择排序 - 堆排序
        System.out.println("selectionSort: " + Arrays.toString(selectionSort(array)));
    }

    /**
     * 选择排序 - 堆排序
     *
     * 数组 - 堆的存储：
     * 第一级节点 0
     * 第二级节点 1、2
     * 第三级节点 3、4、5、6
     * ....每级节点数量是上一级数量的2倍
     *
     * 堆化：最大堆、最小堆
     * 每个有叶子节点的节点调整即可（按照最大堆、最小堆规则）
     * @param array
     * @return
     */
    public static int[] heapSort(int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }
        return null;
    }

    /**
     * 选择排序 - 直接选择排序
     * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
     * 然后在剩下的数当中再找最小的与第二个位置的数交换，
     * 如此循环到倒数第二个数和最后一个数比较为止
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }
        int minIndex;
        for (int i = 0; i < array.length - 1; i++) {
            minIndex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            swap(array, i, minIndex);
            System.out.println(Arrays.toString(array));
        }
        return array;
    }

    /**
     * 插入排序 - 希尔排序
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }
        //System.out.println(Arrays.toString(array));
        int d = array.length;
        while (true) {
            // 每次分组 d 默认为上一次的一半
            d = d / 2;
            //System.out.println("总分组数 " + d + " 组");
            // 循环各个分组（d个分组）
            for (int x = 0; x < d; x++) {
                //System.out.println("当期第 " +x+ " 组排序, 组内元素：");
                // 循环每个分组中的元素
                for (int i = x; i < array.length; i = i + d) {
                    //System.out.print(array[i] + " ");
                    int temp = array[i];
                    int j;
                    // 对分组中每个元素进行插入排序
                    for (j = i - d; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
                //System.out.println(Arrays.toString(array));
            }
            if (d == 1) {
                break;
            }
        }
        return array;
    }

    /**
     * 插入排序 - 二分插入
     * 每次插入时，按照折半查找的方式找到 i 应当插入的位置
     *
     * @param array
     * @return
     */
    public static int[] binaryInsertSort(int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }
        int temI, left, right, middle;
        for (int i = 0; i < array.length; ++i) {
            temI = array[i];
            left = 0;
            right = i - 1;
            while (left <= right) {
                middle = (right + left) / 2;
                //System.out.println("i:" + i + " left:" + left + " right:" + right + " middle:" + middle );
                if (temI > array[middle]) {
                    left = middle + 1;
                } else {
                    right = middle - 1;
                }
            }
            insert(array, i, left);
            //System.out.println(Arrays.toString(array));
        }

        return array;
    }

    /**
     * 插入排序 - 直接插入（从后向前找到合适位置后插入）
     * 每步将一个待排序的记录，按其顺序码大小插入到前面已经排序的字序列的合适位置（从后向前找到合适位置后），
     * 直到全部插入排序完为止
     */
    public static int[] insertSort(int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }
        for (int i = 1; i < array.length; ++i) {
            int j;
            int temI = array[i];
            for (j = i - 1; j >= 0; --j) {
                if (temI < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temI;
        }
        return array;
    }

    /**
     * 把第i个元素插入j位置，j之后i之前元素后挪一位
     *
     * @param array
     * @param i
     * @param
     */
    public static void insert(int[] array, int i, int j) {
        if (j >= i) {
            return;
        } else {
            int temI = array[i];
            for (int k = i; k > j; --k) {
                array[k] = array[k - 1];
            }
            array[j] = temI;
        }
    }

    /**
     * 冒泡排序
     * 冒泡排序算法的运作如下：（从后往前）
     * 1. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
     * 3. 针对所有的元素重复以上的步骤，除了最后一个。
     * 4. 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (null == array || array.length == 0) {
            return null;
        }
        // 第一个循环记录已完成排序次数，倒序
        for (int i = 0; i < array.length; ++i) {
            // 比较每个相邻的元素，除了已完成排序的元素
            for (int j = 0; j < array.length - 1 - i; ++j) {
                // 交换
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
        return array;
    }

    /**
     * 元素交换
     *
     * @param array
     * @param i
     * @param j
     */
    public static void swap(int[] array, int i, int j) {
        if (null == array || i > array.length || j > array.length) {
            return;
        }
        int tem = array[i];
        array[i] = array[j];
        array[j] = tem;
    }
}
