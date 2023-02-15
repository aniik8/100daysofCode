package Tree;
import java.util.List;
public class TreeClass {
}
class Node{
    int data;
    Node leftChild;
    Node rightChild;
}
class tree{
    Node root;
    public void insertNode(int data){
        Node newNode = new Node();
        Node parent;
        newNode.data = data;
        if(root == null)
            root = newNode;
        else{
            Node current = newNode;
            while(true){
                parent = current;
                if(data < current.data){
                    current = current.leftChild;
                    if(current == null){
                        parent.leftChild = newNode;
                        return;
                    }
                }else{
                    current = current.rightChild;
                    if(current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean findNode(int key){

        Node current = root;
        while(current != null){
            if(key == current.data){
                return true;
            }else if(key > current.data){
                current = current.rightChild;
            }
            else{
                current = current.leftChild;
            }
        }
        return false;
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
        traverse(root.left);
        res.add(root.val);
        traverse(root.right);
    }

}