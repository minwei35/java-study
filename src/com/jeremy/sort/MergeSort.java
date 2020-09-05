package com.jeremy.sort;

import java.util.Arrays;

/**
 * @program: java-study
 * @description: 归并排序
 * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
 * @author: jeremysang
 * @create: 2020/9/5
 **/
public class MergeSort extends BaseSort{
    @Override
    public int[] sort(int[] arrays) {
        if (arrays.length < 2){
            return arrays;
        }
        int middle = arrays.length/2;
        int[] left = Arrays.copyOfRange(arrays,0,middle);
        int[] right = Arrays.copyOfRange(arrays,middle,arrays.length);
        return merge(sort(left),sort(right));
    }

    public int[] merge(int[] left,int[] right){
        int[] result = new int[left.length + right.length];
        for (int index=0,i=0,j=0;index<result.length;index++){
            if (i >= left.length){
                result[index] = right[j++];
            }else if (j >= right.length){
                result[index] = left[i++];
            }else if (left[i]>right[j]){
                result[index] = right[j++];
            }else {
                result[index] = left[i++];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BaseSort sort = new MergeSort();
        sort.run();
    }
}
