package com.jeremy.rbt;

/**
 * @program: java-study
 * @description: 红黑树实现
 * @author: JeremySan
 * @create: 2020-08-12
 **/
public class RedBlackTree<T extends Comparable<T>> {
    // 根节点
    private RBTNode<T> root;

    // 红黑的状态值
    private static final boolean RED = true;
    private static final boolean BLACK = true;

    // 叶子节点的内部类实现
    public class RBTNode<T extends Comparable<T>>{
        // 颜色，红色还是黑色
        boolean color;
        // 节点中存放的键值
        T key;
        // 左节点
        RBTNode<T> left;
        // 右节点
        RBTNode<T> right;
        // 父节点
        RBTNode<T> parent;

        // 构造函数
        public RBTNode(boolean color, T key, RBTNode<T> left, RBTNode<T> right, RBTNode<T> parent) {
            this.color = color;
            this.key = key;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }



    }

    /*
      左旋：待旋转的节点从右边上升到父节点
      * 左旋示意图(对节点x进行左旋)：
      *      px                              px
      *     /                               /
      *    x                               y
      *   /  \      --(左旋)--            / \
      *  lx   y                          x  ry
      *     /   \                       /  \
      *    ly   ry                     lx  ly
      *
      *
    */
    private void leftRotate(RBTNode<T> x){
        // x的右节点设置为y
        RBTNode<T> y = x.right;

        // 将y的左节点设为x的右节点
        x.right = y.left;
        // 如果左节点不为空，x则作为这个节点的父节点
        // 这里需要把左节点的原先父亲关系改变
        if (y.left != null) {
            y.left.parent = x;
        }
        // 如果x的父节点不是空的话
        if (x.parent!=null){
            // 如果x是父节点的左孩子
            // 则把y变成父节点的左孩子
            if (x.parent.left == x){
                x.parent.left = y;
            }else {
                // 如果是右孩子，则挂在右孩子这
                x.parent.right = y;
            }
        }else {
            // x的父节点为空的话，则y就变为根节点
            this.root = y;
        }
        // 处理完后，x的父节点为y，y的左节点则为x
        x.parent = y;
        y.left = x;
    }

    /*
    右旋：待旋转的节点从左边上升到父节点
    * 右旋示意图(对节点y进行左旋)：
    *            py                               py
    *           /                                /
    *          y                                x
    *         /  \      --(右旋)-.            /  \                     #
    *        x   ry                           lx   y
    *       / \                                   / \                   #
    *      lx  rx                                rx  ry
    *
    * */
    private void rightRotate(RBTNode<T> y){
        // y的左节点设置为x
        RBTNode<T> x = y.left;

        // 将x的右节点设为y的左节点
        y.left = x.right;
        // 如果x的右节点不为空
        // 需要改变原先的父亲关系
        if (x.right != null){
            x.right.parent = y;
        }
        // 如果y的父节点不为空
        if (y.parent != null){
            // 如果y是父节点的左孩子
            // 则把x变成父节点的左孩子
            if (y.parent.left == y){
                y.parent.left = x;
            }else {
                // 如果是右孩子，则挂在右孩子这
                y.parent.right = x;
            }
        }else {
            // y的父节点为空的话，则x就变为根节点
            this.root = x;
        }
        // 处理完后，y的父节点为x，x的右节点则为y
        y.parent = x;
        x.right = y;
    }

    
}
