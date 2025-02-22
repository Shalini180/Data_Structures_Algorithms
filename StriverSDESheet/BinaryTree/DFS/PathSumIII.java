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
    public int dfs(TreeNode root, int targetSum, Long currSum, Map<Long, Integer> prefix) {
        if(root == null) return 0;
        currSum += root.val;
        int count = prefix.getOrDefault(currSum - targetSum, 0);
        prefix.put(currSum, prefix.getOrDefault(currSum, 0) + 1);
        count += dfs(root.left, targetSum, currSum, prefix);
        count += dfs(root.right, targetSum, currSum, prefix);
        prefix.put(currSum, prefix.get(currSum) - 1);
        return count;
    }
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> mp = new HashMap<>();
        mp.put(0L, 1);
        return dfs(root, targetSum, 0L, mp);
    }
}
