package com.jeremy.sort;

/**
 * @program: java-study
 * @description: 希尔排序
 * 最佳情况：T(n) = O(nlog2 n)  最坏情况：T(n) = O(nlog2 n)  平均情况：T(n) =O(nlog2n)　
 * @author: jeremysang
 * @create: 2020/9/5
 **/
public class ShellSort extends BaseSort{

    @Override
    public int[] sort(int[] arrays) {
        int len = arrays.length;
        int temp;
        int gap = len/2;
        while (gap > 0){
            // 这里开始对gap分组后，每个单独的组都要进行一个直接插入排序
            for (int i = gap; i < len; i++) {
                // 临时变量存储i下标的值
                temp=arrays[i];
                // 找到当前下标对应的组，进行直接插入排序
                // 即当length为10时，gap为5，这里则是判断a[0]和a[5]的值
                int index = i - gap;
                while (index>=0 && temp<arrays[index]){
                    arrays[index + gap] = arrays[index];
                    index = index - gap;
                }
                arrays[index + gap] = temp;
            }
            gap /= 2;
        }
        return arrays;
    }

    public static void main(String[] args) {
        BaseSort sort = new ShellSort();
        sort.run();
    }
}
