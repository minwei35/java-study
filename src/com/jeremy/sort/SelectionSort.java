package com.jeremy.sort;

/**
 * @program: java-study
 * @description: 选择排序
 * 最稳定的排序算法
 * 最佳情况：T(n) = O(n²)  最差情况：T(n) = O(n²)  平均情况：T(n) = O(n²)
 * @author: jeremysang
 * @create: 2020/9/5
 **/
public class SelectionSort extends BaseSort{
    @Override
    public int[] sort(int[] arrays) {
        for (int i = 0; i < arrays.length; i++) {
            int minIndex = i;
            for (int j = i; j < arrays.length; j++) {
                if (arrays[j]<arrays[minIndex]){
                    minIndex=j;
                }
            }
            int temp = arrays[minIndex];
            arrays[minIndex] = arrays[i];
            arrays[i] = temp;
        }
        return arrays;
    }

    public static void main(String[] args) {
        BaseSort sort = new SelectionSort();
        sort.run();
    }
}
