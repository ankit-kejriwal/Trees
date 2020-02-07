import java.util.LinkedList;
import java.util.Queue;

public class TreeSet1 {
    TreeNode root;
    public class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        public TreeNode(int data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
        /*
                            1
                      2             3
                  4      5       6     7
    */

        private TreeNode createFullBinaryTree()
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
            n4.left = new TreeNode(8);
            n4.right = new TreeNode(9);

            return root;
        }

    /*
                            1
                      2             3
                  4      5        6
                7
    */

        private TreeNode createNonFullBinaryTree()
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

            return root;
        }

        private boolean checkIsFull(TreeNode root){
            if(root == null){
                return true;
            }
            if(root.left == null && root.right !=null)
                return false;

            if(root.right == null && root.left!=null)
                return false;
            return checkIsFull(root.left) && checkIsFull(root.right);

        }

        private boolean checkisFullIterative(TreeNode root){
            if (root == null)
                return true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                TreeNode res = queue.poll();
                if(res.left != null && res.right != null){
                   queue.add(res.left);
                   queue.add(res.right);
                }
                if(res.left != null && res.right == null){
                    return false;
                }
                if(res.right != null && res.left == null){
                    return false;
                }
            }
            return true;
        }

        private boolean checkCompleteIterative(){
            if(this.root == null)
                return true;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(this.root);
            boolean isLast = false;
            while(!queue.isEmpty()){
                TreeNode curr = queue.remove();
                if(curr.left == null && curr.right == null)
                    isLast = true;
                if(curr.left != null && curr.right != null){
                    if(isLast){
                        return  false;
                    }
                    queue.add(curr.left);
                    queue.add(curr.right);
                }
                if(curr.left != null && curr.right == null){
                    if(isLast)
                        return false;
                    isLast = true;
                    queue.add(curr.left);
                }
                if(curr.left == null && curr.right!=null)
                    return false;
            }
            return true;
        }

        public  static void  main(String[] args) {
            TreeSet1 tree = new TreeSet1();
            tree.createNonFullBinaryTree();
            System.out.println(tree.checkIsFull(tree.root));
            System.out.println("Iterative "+tree.checkisFullIterative(tree.root));
            System.out.println("complete "+tree.checkCompleteIterative());
            tree.createFullBinaryTree();
            System.out.println(tree.checkIsFull(tree.root));
            System.out.println("Iterative "+tree.checkisFullIterative(tree.root));
            System.out.println("complete "+tree.checkCompleteIterative());
        }
}
