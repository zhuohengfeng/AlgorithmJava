package datastructure;

import java.util.ArrayDeque;

/**
 * 树的深度优先遍历需要用到额外的数据结构--->栈；
 * 而广度优先遍历需要--->队列来辅助；
 * 这里以二叉树为例来实现。
 *
 * Author: zhuohf
 * Date: 2019-11-2
 *
 */
public class BinaryTree {

    /**
     * 定义二叉树结构
     */
    class TreeNode {
        int value;
        TreeNode leftNote;
        TreeNode rightNote;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    // 定义根节点
    public TreeNode rootNote;

    // 构造函数，传入数组转换成一棵二叉树
    public BinaryTree(int[] arrays) {
        rootNote = makeArrayToBinaryTree(arrays, 0);
    }


    /**
     * 采用递归的方式创建一颗二叉树
     * 传入的是二叉树的数组表示法
     * 构造后是二叉树的二叉链表表示法
     */
    private TreeNode makeArrayToBinaryTree(int[] arrays, int index) {
        if (index < arrays.length) {
            int value = arrays[index];
            TreeNode t = new TreeNode(value);
            t.leftNote = makeArrayToBinaryTree(arrays, index*2+1);
            t.rightNote = makeArrayToBinaryTree(arrays, index*2+2);
            return t;
        }

        return null;
    }

    /**
     * 深度优先遍历 --- 需要栈
     */
    public void depthOrderTraversal() {
        if(rootNote==null){
            System.out.println("empty tree");
            return;
        }
        System.out.print("\n深度优先：");
        // 创建一个栈 -- 双端队列可以是栈也可以是队列
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        // 把根节点入栈
        stack.push(rootNote);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.print(node.value + "  ");
            if (node.rightNote != null) {
                stack.push(node.rightNote);
            }
            if (node.leftNote != null) {
                stack.push(node.leftNote);
            }
        }
    }

    /**
     * 广度优先遍历 --- 需要队列
     */
    public void levelOrderTraversal() {
        if(rootNote==null){
            System.out.println("empty tree");
            return;
        }
        System.out.print("\n广度优先：");
        // 创建一个队列 -- 双端队列可以是栈也可以是队列
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(rootNote);
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            System.out.print(node.value + "  ");
            if (node.leftNote != null) {
                queue.add(node.leftNote);
            }
            if (node.rightNote != null) {
                queue.add(node.rightNote);
            }
        }
    }

    /**
     * 前序遍历
     * @param node
     */
    public void preOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + "  ");
        preOrderTraversal(node.leftNote);
        preOrderTraversal(node.rightNote);
    }


    /**
     * 中序遍历
     * @param node
     */
    public void midOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraversal(node.leftNote);
        System.out.print(node.value + "  ");
        preOrderTraversal(node.rightNote);
    }

    /**
     * 后序遍历
     * @param node
     */
    public void postOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        preOrderTraversal(node.leftNote);
        preOrderTraversal(node.rightNote);
        System.out.print(node.value + "  ");
    }

    /**
     深度优先：1  2  4  8  9  5  10  11  3  6  12  13  7  14  15
     广度优先：1  2  3  4  5  6  7  8  9  10  11  12  13  14  15

     前序遍历：1  2  4  8  9  5  10  11  3  6  12  13  7  14  15
     中序遍历：2  4  8  9  5  10  11  1  3  6  12  13  7  14  15
     后序遍历：2  4  8  9  5  10  11  3  6  12  13  7  14  15  1
     */
    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        BinaryTree binaryTree = new BinaryTree(arrays);
        binaryTree.depthOrderTraversal();
        binaryTree.levelOrderTraversal();
        System.out.print("\n前序遍历：");
        binaryTree.preOrderTraversal(binaryTree.rootNote);
        System.out.print("\n中序遍历：");
        binaryTree.midOrderTraversal(binaryTree.rootNote);
        System.out.print("\n后序遍历：");
        binaryTree.postOrderTraversal(binaryTree.rootNote);
    }

}
