/*

https://leetcode.com/problems/path-sum-iii/

Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.
The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes).

Constraints:
1. The number of nodes in the tree is in the range [0, 1000].
2. -109 <= Node.val <= 109
3. -1000 <= targetSum <= 1000

Input: root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
Output: 3
    Explanation: The paths that sum to 8 are shown.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: 3

*/

import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class PathSumIII {
    public static void main(String[] args) {
        PathSumIII lc = new PathSumIII();

        TreeNode root = new TreeNode(10,
                new TreeNode(5,
                        new TreeNode(3,
                                new TreeNode(3),
                                new TreeNode(-2)),
                        new TreeNode(2,
                                null,
                                new TreeNode(1))),
                new TreeNode(-3,
                        null,
                        new TreeNode(11)));
        System.out.println(lc.pathSum(root, 8));

        root = new TreeNode(5,
                new TreeNode(4,
                        new TreeNode(11,
                                new TreeNode(7),
                                new TreeNode(2)),
                        null),
                new TreeNode(8,
                        new TreeNode(13),
                        new TreeNode(4,
                                new TreeNode(5),
                                new TreeNode(1))));
        System.out.println(lc.pathSum(root, 22));
    }

    public int pathSum(TreeNode root, int targetSum) {
        int[] count = new int[1];
        HashMap<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);

        dfs(root, targetSum, 0, preSum, count);

        return count[0];
    }

    private void dfs(TreeNode root, int targetSum, int currSum, HashMap<Integer, Integer> preSum, int[] count) {
        if (root == null) {
            return;
        }

        currSum += root.val;

        if (preSum.containsKey(currSum - targetSum)) {
            count[0] += preSum.get(currSum - targetSum);
        }

        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);

        dfs(root.left, targetSum, currSum, preSum, count);
        dfs(root.right, targetSum, currSum, preSum, count);

        preSum.put(currSum, preSum.getOrDefault(currSum, 0) - 1);
    }
}
