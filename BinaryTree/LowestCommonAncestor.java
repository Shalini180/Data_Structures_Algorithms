/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return root;
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode right = helper(root.right, p, q);
        TreeNode left = helper(root.left, p, q);
        if(left != null && right != null) return root;
        return (left != null) ? left : right;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q);
    }
}
