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
    public int helper(TreeNode root, Integer currSum){
        if(root == null) return 0;
        currSum = currSum * 10 + root.val;

        if(root.left == null && root.right == null){
            return currSum;
        }

        return helper(root.left, currSum) + helper(root.right, currSum);
    }
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
}
