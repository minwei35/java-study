package com.jeremy.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: java-study
 * @description: 基础父类
 * @author: jeremysang
 * @create: 2020/9/5
 **/
public abstract class BaseSort {
    Random random = new Random();
    public abstract int[] sort(int[] arrays);
    public void run(){
        int[] arrays = getRandomArrays(1000);
        printArrays(arrays);
        Runtime r = Runtime.getRuntime();
        // 开始时的剩余内存
        long startMem = r.freeMemory();
        long start = System.currentTimeMillis();
        arrays = this.sort(arrays);
        System.out.println(String.format("排序耗时为%dms", System.currentTimeMillis() - start));
        // 现在剩余内存
        long orz = startMem - r.freeMemory();
        // 右移20位，即orz/1024/1024
        System.out.println(String.format("排序消耗内存为%dMB", orz >> 20));
        printArrays(arrays);
    }
    public int[] getRandomArrays(int size){
        int[] arrays = new int[size];
        for (int i = 0; i < size; i++) {
            arrays[i] = random.nextInt(5000);
        }
        return arrays;
    }

    public void printArrays(int[] arrays){
        StringBuilder result= new StringBuilder();
        for (int array : arrays) {
            result.append(",").append(array);
        }
        System.out.println("数组顺序为："+result.toString().substring(1));
    }
}
