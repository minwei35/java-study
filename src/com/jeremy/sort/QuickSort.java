package com.jeremy.sort;

/**
 * @program: java-study
 * @description: 快速排序
 * @author: jeremysang
 * @create: 2020/9/5
 **/
public class QuickSort extends BaseSort {
    @Override
    public int[] sort(int[] arrays) {
        return quickSort(arrays, 0, arrays.length-1);
    }

    private int[] quickSort(int[] arrays, int start, int end) {
        if (start < end) {
            int partition = partition(arrays,start,end);
            quickSort(arrays,start,partition-1);
            quickSort(arrays,partition+1,end);
        }
        return arrays;
    }

    private int partition(int[] array,int left,int right){
        int index = left + 1;
        for (int i = index; i <= right; i++) {
            if (array[i]<array[left]){
                swap(array,i,index);
                index++;
            }
        }
        swap(array, left,index-1);
        return index-1;
    }

    private void swap(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) {
        BaseSort sort = new QuickSort();
        sort.run();
    }
}
