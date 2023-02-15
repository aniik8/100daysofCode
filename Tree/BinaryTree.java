package Tree;

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
}
class TreeNode{
    TreeNode leftNode, rightNode;
    int data;

    TreeNode(int data){
        this.data = data;
    }
}
