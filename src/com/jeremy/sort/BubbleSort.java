package com.jeremy.sort;

/**
 * @program: java-study
 * @description: 冒泡排序
 * 排序最佳情况：T(n) = O(n)   最差情况：T(n) = O(n²)   平均情况：T(n) = O(n²)
 * @author: jeremysang
 * @create: 2020/9/5
 **/
public class BubbleSort extends BaseSort{

    @Override
    public int[] sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if(array[j+1] < array[j]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        BaseSort sort = new BubbleSort();
        sort.run();
    }
}
