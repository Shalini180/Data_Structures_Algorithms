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
    public boolean isLeaf(TreeNode root) {
        if (root.left == null && root.right == null) return true;
        return false;
    }

    public void helper(TreeNode root, int[] ans) {
        if (root == null) return;

        if (root.left != null) {
            boolean isLeaf = isLeaf(root.left);
            if (isLeaf) {
                ans[0] += root.left.val;
            }
        }

        helper(root.left, ans);
        helper(root.right, ans);
    }

    public int sumOfLeftLeaves(TreeNode root) {
        int[] ans = new int[1];
        helper(root, ans);
        return ans[0];
    }
}
