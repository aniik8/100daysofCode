package 100daysofCode.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BinaryTree {
    public static void main(String[] args) {
        insertNode();

    }
    public static TreeNode insertNode(){
        Scanner sc = new Scanner(System.in);
        TreeNode root = null;
        System.out.println("Enter data");
        int data = sc.nextInt();
        if(data == -1) return null;
        root = new TreeNode(data);
        System.out.println("Enter left node : ");
        root.leftNode = insertNode();
        System.out.println("Enter right node : ");
        root.rightNode = insertNode();
        return root;

    }
    // leetcode 94.
    private List<Integer> res = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.leftNode);
        res.add(root.data);
        traverse(root.rightNode);
    }

    // Leetcode 144
    List<Integer> list2 = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return list2;
        preOrderAdd(root);
        return list2;
    }
    void preOrderAdd(TreeNode root){
        list2.add(root.data);
        preOrderAdd(root.leftNode);
        preOrderAdd(root.rightNode);
    }
    //Leetcode 145
    List<Integer> list3 = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) return list3;
        postOrderAdd(root);
        return list3;
    }
    void postOrderAdd(TreeNode root){
        if(root == null) return;
        postOrderAdd(root.leftNode);
        postOrderAdd(root.rightNode);
        list3.add(root.data);
    }
}
class TreeNode{
    TreeNode leftNode, rightNode;
    int data;

    TreeNode(int data){
        this.data = data;
    }
}
