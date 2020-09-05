package com.jeremy.sort;

/**
 * @program: java-study
 * @description: 直接插入排序
 * 最佳情况：T(n) = O(n)   最坏情况：T(n) = O(n²)   平均情况：T(n) = O(n²)
 * @author: jeremysang
 * @create: 2020/9/5
 **/
public class InsertionSort extends BaseSort{
    @Override
    public int[] sort(int[] arrays) {
        int current;
        for (int i = 0; i < arrays.length-1; i++) {
            current = arrays[i+1];
            int index = i;
            while (index>=0 && current<arrays[index]){
                arrays[index+1] = arrays[index];
                index--;
            }
            arrays[index+1] = current;
        }
        return arrays;
    }

    public static void main(String[] args) {
        BaseSort sort = new InsertionSort();
        sort.run();
    }
}
