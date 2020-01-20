import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrder {
    TreeNode root;

    class TreeNode {
        private int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args){
        PostOrder postOrder = new PostOrder();
        postOrder.createSampleTree();
        postOrder.postOrderTraversal(postOrder.root);
        System.out.println();
        postOrder.postOrderTraversalWithoutRecursion(postOrder.root);
    }

    public void createSampleTree(){
        root = new TreeNode(1,new TreeNode(2,new TreeNode(4),null),new TreeNode(3,new TreeNode(7),new TreeNode(5)));
    }

    public void postOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" ");
    }

    public static void postOrderTraversalWithoutRecursion(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(0,temp.data);
            if(temp.left !=null){
                stack.push(temp.left);
            }
            if(temp.right !=null){
                stack.push(temp.right);
            }
        }
        for (int i: list
             ) {
            System.out.print(i+" ");
        }
    }

}
