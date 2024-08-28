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
    public TreeNode searchHelper(TreeNode root, int val){
        if(root == null) return null;
        if(root.val == val) return root;
        TreeNode left = searchHelper(root.left, val);
        if(left != null) return left;
        TreeNode right = searchHelper(root.right, val);
        if(right != null) return right;
        if(root.val < val) return searchHelper(root.right, val);
        return searchHelper(root.left, val);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return searchHelper(root, val);
    }
}
