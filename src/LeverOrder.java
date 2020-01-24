import java.util.LinkedList;
import java.util.Queue;

public class LeverOrder {
    TreeNode root;
    public  class TreeNode{
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

    public void createSampleTree(){
        root = new TreeNode(4,new TreeNode(2,new TreeNode(1),new TreeNode(3)),new TreeNode(6,new TreeNode(5),new TreeNode(7)));
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

    public static void main(String[] args) {
        LeverOrder leverOrder = new LeverOrder();
        leverOrder.createSampleTree();
        leverOrder.levelOrderTraversal(leverOrder.root);
    }
}
