/*

https://leetcode.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/

Given two integer arrays, preorder and postorder where preorder is the preorder traversal of a binary tree of distinct values and postorder is the postorder traversal of the same tree, reconstruct and return the binary tree.
If there exist multiple answers, you can return any of them.

Constraints:
1. 1 <= preorder.length <= 30
2. 1 <= preorder[i] <= preorder.length
3. All the values of preorder are unique.
4. postorder.length == preorder.length
5. 1 <= postorder[i] <= postorder.length
6. All the values of postorder are unique.
7. It is guaranteed that preorder and postorder are the preorder traversal and postorder traversal of the same binary tree.

Input: preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
Output: [1,2,3,4,5,6,7]

Input: preorder = [1], postorder = [1]
Output: [1]

*/

public class ConstructBinaryTreefromPreorderandPostorderTraversal {
    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandPostorderTraversal lc = new ConstructBinaryTreefromPreorderandPostorderTraversal();

        PrintBinaryTree print = new PrintBinaryTree();

        TreeNode res = lc.constructFromPrePost(new int[]{1, 2, 4, 5, 3, 6, 7}, new int[]{4, 5, 2, 6, 7, 3, 1});
        print.print(print.printTree(res));

        lc.preIdx = 0;
        lc.postIdx = 0;
        res = lc.constructFromPrePost(new int[]{1}, new int[]{1});
        print.print(print.printTree(res));
    }

    int preIdx = 0, postIdx = 0;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = preorder.length;
        TreeNode root = new TreeNode(preorder[preIdx++]);

        if (root.val != postorder[postIdx]) {
            root.left = constructFromPrePost(preorder, postorder);
        }

        if (root.val != postorder[postIdx]) {
            root.right = constructFromPrePost(preorder, postorder);
        }

        postIdx++;
        return root;
    }
}
