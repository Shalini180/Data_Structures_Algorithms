/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean helper(TreeNode curr) {
        if (curr == null) return false;

        if (curr.left == null && curr.right == null) {
            return curr.val == 1;
        }

        boolean left = helper(curr.left);
        boolean right = helper(curr.right);

        if (curr.val == 2) {
            return left || right;
        }

        // If the current node is an AND operation
        return left && right;
    }

    public boolean evaluateTree(TreeNode root) {
        return helper(root);
    }
}
