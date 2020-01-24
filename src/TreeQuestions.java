import java.util.*;

public class TreeQuestions {
    TreeNode root;
    class TreeNode{
        int data;
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

    /*
     * Create a sample tree
     *              1
     *      2               3
     * 4        5       6       7
     */
    public void createSampleTree() {
        root = new TreeNode(1, new TreeNode(2, new TreeNode(4, new TreeNode(9),null), new TreeNode(5,null, new TreeNode(11))), new TreeNode(3, new TreeNode(6,null,new TreeNode(8)), new TreeNode(7)));
    }
    public void levelOrderTraversal(TreeNode temp){
        if(temp == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(temp);
        while (!queue.isEmpty()){
            TreeNode curr = queue.poll();
            System.out.print(curr.data+ " ");
            if(curr.left !=null){
                queue.add(curr.left);
            }
            if(curr.right !=null){
                queue.add(curr.right);
            }
        }

    }
    public void noSibling(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left != null  && root.right == null){
            System.out.print(root.left.data+" ");
        }
        if(root.right != null  && root.left == null){
            System.out.print(root.right.data+" ");
        }
        noSibling(root.left);
        noSibling(root.right);
    }

    public void allPathToLeaf(TreeNode root){
        if(root == null){
            return;
        }
        printPath(root,new ArrayList<Integer>());
    }
    public  void  printPath(TreeNode root , List<Integer> list){
        if(root == null){
            return;
        }
        list.add(root.data);
        if(root.right == null && root.left == null) {
            for(int i: list){
                System.out.print(i+" ");
            }
            System.out.println();
        }
        printPath(root.left,new ArrayList<>(list));
        printPath(root.right,new ArrayList<>(list));
    }

    public int minDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int ldepth = root.left !=null?minDepth(root.left): Integer.MAX_VALUE;
        int rdepth = root.right!=null?minDepth(root.right):Integer.MAX_VALUE;
        return 1+ Math.min(ldepth,rdepth);
    }

    public static void main(String[] args) {
        TreeQuestions treeQuestions = new TreeQuestions();
        treeQuestions.createSampleTree();
        treeQuestions.levelOrderTraversal(treeQuestions.root);
        System.out.println();
        treeQuestions.noSibling(treeQuestions.root);
        System.out.println();
        treeQuestions.allPathToLeaf(treeQuestions.root);
        System.out.println();
        System.out.println(treeQuestions.minDepth(treeQuestions.root));
    }

}
