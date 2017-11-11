package com.soul.tree;

import java.util.Stack;

/**
 * @author WK
 */
public class SearchBinaryTree {

    //存放的结点标志
    public String tag = "";
    //是否被便利的标志
    public boolean flag = false;
    //左孩子
    public SearchBinaryTree leftChild = null;
    //右孩子
    public SearchBinaryTree rightChild = null;

    public SearchBinaryTree(String tag) {
        this.tag = tag;
    }

    /**
     *
     * @param T 传入的树的根结点
     */
    public static void priorOrderNonRecursive(SearchBinaryTree T) {
        //构造stack
        Stack<SearchBinaryTree> binaryTrees = new Stack<>();
        SearchBinaryTree p = T;

        //保证所有节点被遍历过
        while (p != null || (!binaryTrees.empty())) {

            //未被遍历则输出tag，入栈
            if (p.flag == false) {
                System.out.println(p.tag);
                p.flag = true;
                binaryTrees.push(p);
            }
            //左孩子不为空且左孩子未被遍历过（防止重复入栈）
            if (p.leftChild != null && p.leftChild.flag == false) {
                p = p.leftChild;
                continue;
            }
            //右孩子不为空且右孩子未被遍历过（防止重复入栈）
            if (p.rightChild != null && p.rightChild.flag == false) {
                p = p.rightChild;
                continue;
            }

            //如果左右孩子都为空则需要出栈。
            if (!binaryTrees.empty())
                p = binaryTrees.pop();
            else
                p = null;

        }

    }

    /**
     * 中序遍历和前序的区别就在于遍历的位置，也就是输出tag的位置，其他完全类似
     * @param root 传入的树的根结点
     */
    public static void infixOrderNonRecursive(SearchBinaryTree root) {
        Stack<SearchBinaryTree> binaryTrees = new Stack<>();
        SearchBinaryTree p = root;
        while (p != null || (!binaryTrees.empty())) {

            if (p.flag == false)
                binaryTrees.push(p);
            if (p.leftChild != null && p.leftChild.flag == false) {
                p = p.leftChild;
                continue;
            }

            if (p.flag == false) {
                System.out.println(p.tag);
                p.flag = true;

            }
            if (p.rightChild != null && p.rightChild.flag == false) {
                p = p.rightChild;
                continue;
            }

            if (!binaryTrees.empty())
                p = binaryTrees.pop();
            else
                p = null;

        }
    }

    /**
     *可以发现其实后序遍历的代码与前两个也类似，只是遍历位置不同，由此可见非循环遍历其实也并不难
     * @param root
     */
    public static void postOrderNonRecursive(SearchBinaryTree root) {
        Stack<SearchBinaryTree> binaryTrees = new Stack<>();
        SearchBinaryTree p = root;
        while (p != null || (!binaryTrees.empty())) {

            if (p.flag == false)
                binaryTrees.push(p);
            if (p.leftChild != null && p.leftChild.flag == false) {
                p = p.leftChild;
                continue;
            }


            if (p.rightChild != null && p.rightChild.flag == false) {
                p = p.rightChild;
                continue;
            }

            if (p.flag == false) {
                System.out.println(p.tag);
                p.flag = true;

            }
            if (!binaryTrees.empty())
                p = binaryTrees.pop();
            else
                p = null;

        }
    }

    public static void main(String[] args) {
        SearchBinaryTree root = initTree();
        System.out.println("--------前序遍历开始：");
        priorOrderNonRecursive(root);
        System.out.println("--------中序遍历开始：");
        root = initTree();
        infixOrderNonRecursive(root);
        System.out.println("--------后序遍历开始：");
        root = initTree();
        postOrderNonRecursive(root);
    }


    private static SearchBinaryTree initTree() {
        SearchBinaryTree A = new SearchBinaryTree("A");
        SearchBinaryTree B = new SearchBinaryTree("B");
        SearchBinaryTree C = new SearchBinaryTree("C");
        SearchBinaryTree D = new SearchBinaryTree("D");
        SearchBinaryTree E = new SearchBinaryTree("E");
        SearchBinaryTree F = new SearchBinaryTree("F");
        SearchBinaryTree G = new SearchBinaryTree("G");
        A.leftChild = B;
        A.rightChild = F;
        B.leftChild = C;
        B.rightChild = D;
        D.leftChild = E;
        F.leftChild = G;

        return A;
    }
}
