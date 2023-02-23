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
    // leetcode 104.
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.leftNode), maxDepth(root.rightNode)) + 1;
    }

    // Size of a binary tree
    // size of a binary tree ---->
    public static int sizeOfTree(TreeNode root){
        if(root == null) return 0;
        return sizeOfTree(root.leftNode) + sizeOfTree(root.rightNode) + 1;
    }
// maximum of a binary tree
    public static int maximumOfTree(TreeNode root){
        if(root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maximumOfTree(root.leftNode), maximumOfTree(root.rightNode)));
    }
// minimum of a binary tree
    public static int minimumofTree(TreeNode root){
        if(root == null) return Integer.MAX_VALUE;
        return Math.min(root.data, Math.min(minimumofTree(root.leftNode), minimumofTree(root.rightNode)));
    }
// 199. binary tree right side view
    List<Integer> list4 = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)
            return list4;
        rightView(root, 0);
        return list4;
    }
    void rightView(TreeNode root, int level){
        if(root == null) return;
        if(level == list4.size()){
            list4.add(root.data);
        }
        rightView(root.rightNode, level+1);
        rightView(root.leftNode, level+1);
    }
    // leetcode 114..
        TreeNode prev = null, next = null;
        TreeNode head;
        public void flatten(TreeNode root) {
            if(root == null) return;
            flatten(root.leftNode);
            if(prev == null)head = root;
            else{
                root.leftNode = prev;
                prev.rightNode = root;
            }
            prev = root;
            flatten(root.rightNode);
        }
// 543
public static int diameterOfBinaryTree(TreeNode root) {
    if(root == null) return 0;
    int diameterofleft = diameterOfBinaryTree(root.leftNode);
    int diameterofright = diameterOfBinaryTree(root.rightNode);
    int leftright = sizeOfTree(root.leftNode) + sizeOfTree(root.rightNode) + 1;
    return Math.max(leftright, Math.max(diameterofright, diameterofleft));
}
// optimised 543
    int ans =0;
    public int diameterofBinary(TreeNode root){

        if(root == null) return 0;
        int left = diameterofBinary(root.leftNode);
        int right = diameterofBinary(root.rightNode);
        ans = Math.max(ans, 1+left+right);
        return 1 + left + right;
    }
//236
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null) return root;
    if(root.data == p.data || root.data == q.data)return root;

    TreeNode left = lowestCommonAncestor(root.leftNode, p, q);
    TreeNode right = lowestCommonAncestor(root.rightNode, p, q);

    if(left == null) return right;
    if(right == null) return left;

    return root;
}
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        TreeNode temp = root;
        while(temp != null) {
            if(temp.val == key){
                if(temp.left != null) {
                    temp.val = temp.left.val;
                    temp.left = null;
                }
                else if(temp.right != null){
                    temp.val = temp.right.val;
                    temp.right = null;
                }else{
                    temp = null;
                }
            }
            else if (temp.val > key) {
                temp = temp.left;
            }
            else temp = temp.right;
        }
        return root;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return root;
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }
        else if(key>root.val){
            root.right=deleteNode(root.right,key);
        }
        else{
            if(root.left==null) return root.right;
            if(root.right==null) return root.left;

            root.val=minvalue(root.right);//to find inorder succesor

            root.right=deleteNode(root.right,root.val);
        }
        return root;
    }

    public int minvalue(TreeNode root){
        int min=root.val;
        while(root.left!=null){
            min=root.left.val;
            root=root.left;
        }
        return min;
    }
    public TreeNode searchBST(TreeNode root, int val) {
        while(root != null){
            if(root.data == val){
                return root;
            }else if(root.data > val){
                root = root.leftNode;
            }else root = root.rightNode;
        }
        return root;
    }
    // leetcode 1008    https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
}
class Solution {
    public int removeDuplicates(int[] nums) {
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[j]){
                nums[j+1]=nums[i];
                j++;}
        }
        return j+1;
    }
}
class TreeNode{
    TreeNode leftNode, rightNode;
    int data;

    TreeNode(int data){
        this.data = data;
    }
}
