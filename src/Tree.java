import apple.laf.JRSUIUtils;

import java.util.Stack;

public class Tree {
    private TreeNode root;
    class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static void  main(String[] args){
        Tree tree = new Tree();
        tree.createSampleTree();
        tree.printPreoder(tree.root);
        System.out.println();
        tree.printPreOrderWithoutRecursion(tree.root);
    }
    public void createSampleTree() {
        root = new TreeNode(1, new TreeNode(2,new TreeNode(4),null),new TreeNode(3,new TreeNode(7),new TreeNode(5)));
    }

    public void printPreoder(TreeNode root){
        if(root == null)
            return;
        System.out.print(root.data+ " ");
        printPreoder(root.left);
        printPreoder(root.right);
    }

    public void printPreOrderWithoutRecursion(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode temp = stack.pop();
            System.out.print(temp.data+" ");
            if(temp.right !=null){
                stack.push(temp.right);
            }
            if(temp.left !=null){
                stack.push(temp.left);
            }
        }
    }
}
