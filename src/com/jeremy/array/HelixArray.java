package com.jeremy.array;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @program: java-study
 * @description: 螺旋矩阵
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * @author: JeremySan
 * @create: 2020-08-31
 **/
public class HelixArray {
    public static int [][] getHelixArray(int n) {
//        Vector<Vector<Integer>> helixArray = new Vector<>(n);
        int [][] helixArray=new int[n][n];
        // 定义每循环一个圈的起始位置
        int startX = 0,startY = 0;
        // 每个圈循环几次，例如n为奇数3，即循环一次
        int loop = n/2;
        // 获取矩阵正中间的位置，例如n为3，则中间坐标为（1,1）
        int mid = n/2;
        // 用来赋值数组的值，从1开始自增
        int value = 1;
        // 每一圈循环，用来控制每一条边遍历的长度
        int offset = 1;
        int i,j;
        while (loop != 0){
            i = startX;
            j = startY;
            // 第一行的遍历，遍历长度为当前坐标Y+正整数n-边界值offset
            for (j=startY;j<startY + n - offset;j++) {
                helixArray[startX][j] = value++;
            }

            // 模拟填充右列从上到下(左闭右开)
            for (i = startX; i < startX + n - offset; i++) {
                helixArray[i][j] = value++;
            }
            // 模拟填充下行从右到左(左闭右开)
            for (; j > startY; j--) {
                helixArray[i][j] = value++;
            }
            // 模拟填充左列从下到上(左闭右开)
            for (; i > startX; i--) {
                helixArray[i][j] = value++;
            }

            // 第二圈开始的时候，起始位置要各自加1， 例如：第一圈起始位置是(0, 0)，第二圈起始位置是(1, 1)
            startX++;
            startY++;

            // offset 控制每一圈里每一条边遍历的长度
            offset += 2;
            loop--;
        }
        // 如果n为奇数的话，需要单独给矩阵最中间的位置赋值
        if (n % 2 > 0) {
            helixArray[mid][mid] = value;
        }
        return helixArray;
    }

    public static void main(String[] args) {
        int [][] helixArray = getHelixArray(6);
        for (int i = 0; i < helixArray.length; i++) {
            System.out.print("当前第"+ (i+1) +"行数组的值为");
            for (int j : helixArray[i]) {
                System.out.print(j+" ");
            }
            System.out.println(" ");
        }
    }
}
