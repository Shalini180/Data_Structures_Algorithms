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
    public TreeNode insertHelper(TreeNode root, int val){
        if(root == null){
            TreeNode newNode = new TreeNode(val);
            return newNode;
        }
        if(root.val < val){
            root.right = insertHelper(root.right, val);
        }
        else{
            root.left = insertHelper(root.left, val);
        }

        return root;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        return insertHelper(root, val);
    }
}
