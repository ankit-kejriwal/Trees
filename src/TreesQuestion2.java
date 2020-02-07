public class TreesQuestion2 {
    TreeNode root;
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private void createFullBinaryTree()
    {
        this.root = new TreeNode(1);
        TreeNode n1   = new TreeNode(2);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(4);
        TreeNode n4   = new TreeNode(5);
        TreeNode n5   = new TreeNode(6);
        TreeNode n6   = new TreeNode(7);
        root.left  = n1;
        root.right = n2;
        n1.left  = n3;
        n1.right = n4;
        n2.left   = n5;
        n2.right  = n6;
    }

    private void createNonFullBinaryTree()
    {
        this.root = new TreeNode(1);
        TreeNode n1   = new TreeNode(2);
        TreeNode n2   = new TreeNode(3);
        TreeNode n3   = new TreeNode(4);
        TreeNode n4   = new TreeNode(5);
        TreeNode n5   = new TreeNode(6);
        TreeNode n6   = new TreeNode(7);
        root.left  = n1;
        root.right = n2;
        n1.left  = n3;
        n1.right = n4;
        n2.left  = n5;
        n3.left  = n6;
    }

    public boolean checkBinaryTreeRecursive(TreeNode root){
        if(root == null) {
            return true;
        }
        if(root.left== null && root.right == null){
            return true;
        }
        if(root.right == null && root.left!=null){
            return  false;
        }
        if(root.right != null && root.left==null){
            return  false;
        }
        return (checkBinaryTreeRecursive(root.left) && checkBinaryTreeRecursive(root.right));
    }

    public static void main(String[] args){
        TreesQuestion2 tree = new TreesQuestion2();
        tree.createFullBinaryTree();
        System.out.println("Full binary tree -> " + tree.checkBinaryTreeRecursive(tree.root));
        tree.createNonFullBinaryTree();
        System.out.println("Full binary tree -> " + tree.checkBinaryTreeRecursive(tree.root));
    }
}
