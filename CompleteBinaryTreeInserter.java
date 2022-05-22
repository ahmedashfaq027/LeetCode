import java.util.LinkedList;
import java.util.Queue;

class CBTInserter {
    Queue<TreeNode> q;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        q = new LinkedList<>();
        q.add(root);
        this.root = root;

        boolean lastLevel = false;
        while (!lastLevel) {
            TreeNode tmp = q.peek();

            if (tmp.left != null) {
                q.add(tmp.left);
            } else {
                lastLevel = true;
            }

            if (tmp.right != null) {
                q.add(tmp.right);
                q.remove();
            } else {
                lastLevel = true;
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);

        if (q.peek().left != null && q.peek().right != null)
            q.remove();

        TreeNode parent = q.peek();
        if (parent.left == null) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        q.add(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class CompleteBinaryTreeInserter {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                null);

        CBTInserter cBTInserter = new CBTInserter(root);
        System.out.println(cBTInserter.insert(3));  // return 1
        System.out.println(cBTInserter.insert(4));  // return 2
        System.out.println(cBTInserter.get_root()); // return [1, 2, 3, 4]
    }
}
