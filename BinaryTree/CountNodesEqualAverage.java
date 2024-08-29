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
    Integer sum;
    Integer count;
    Integer nodes;
    public Pair(Integer sum, Integer count, Integer nodes){
        this.sum = sum;
        this.count = count;
        this.nodes = nodes;
    }
}
class Solution {
    public Pair helper(TreeNode root){
        if(root == null) return new Pair(0, 0, 0);
        Pair left = helper(root.left);
        Pair right = helper(root.right);
        int currCount = left.count + right.count;
        int currSum = left.sum + right.sum + root.val;
        int nodes = left.nodes + right.nodes + 1;
        if(currSum/nodes == root.val) return new Pair(currSum, currCount + 1, nodes);
        return new Pair(currSum, currCount, nodes);
    }
    public int averageOfSubtree(TreeNode root) {
        Pair ans = helper(root);
        return ans.count;
    }
}
