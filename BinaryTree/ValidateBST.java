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
    public Boolean helper(TreeNode root, Long lower, Long upper){
        if(root == null) return true;
        if(root.val <= lower || root.val >= upper) return false;
        Boolean left = helper(root.left, lower, Long.valueOf(root.val));
        Boolean right = helper(root.right, Long.valueOf(root.val), upper);
        return left && right;
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
