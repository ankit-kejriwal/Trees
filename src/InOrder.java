import java.security.SecureRandom;
import java.util.Stack;

public class InOrder {
    TreeNode root;
    class TreeNode{
        int data;
        TreeNode left,right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public void createSampleTree(){
        root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(6,new TreeNode(5),new TreeNode(7)));
    }

    public static void main(String[] args) {
        InOrder inOrder = new InOrder();
        inOrder.createSampleTree();
        inOrder.inorderTraversal(inOrder.root);
        System.out.println();
        inOrder.inorderTraversalWithoutRecursion(inOrder.root);
    }
    public void inorderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data+ " ");
        inorderTraversal(root.right);
    }

    public void inorderTraversalWithoutRecursion(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while (temp!=null || !stack.isEmpty()){
            while (temp!=null){
                stack.push(temp);
                temp = temp.left;
            }
            temp = stack.pop();
            System.out.print(temp.data +" ");
            temp =temp.right;
        }
    }


}
