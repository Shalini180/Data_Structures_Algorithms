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
    public boolean helper(TreeNode root, int targetSum) {
        if(root.left == null && root.right == null){
            if(root.val == targetSum){
                return true;
            }

            return false;
        }

        boolean check = false;
        if(root.left != null) check |= helper(root.left, targetSum - root.val);
        if(root.right != null) check |= helper(root.right, targetSum - root.val);
        return check;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return helper(root, targetSum);
    }
}
