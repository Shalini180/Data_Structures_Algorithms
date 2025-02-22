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
class Pair {
    int height;
    int diameter;
    public Pair(int height, int diameter){
        this.height = height;
        this.diameter = diameter;
    }
}
class Solution {
    public Pair helper(TreeNode root){
        if(root == null) return new Pair(0, 0);
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int currHeight = Math.max(left.height, right.height) + 1;
        int currDiameter = Math.max(Math.max(left.diameter, right.diameter), left.height + right.height);
        return new Pair(currHeight, currDiameter);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        Pair curr = helper(root);
        return curr.diameter;
    }
}
