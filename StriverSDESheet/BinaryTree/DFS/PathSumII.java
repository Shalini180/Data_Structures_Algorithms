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
    public void helper(TreeNode root, int targetSum, List<Integer> temp, List<List<Integer>> ans){
        if(root == null) return;
        
        temp.add(root.val);
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                ans.add(new ArrayList<>(temp));
            }
        }
        else {
            helper(root.left, targetSum - root.val, temp, ans);
            helper(root.right, targetSum - root.val, temp, ans);
        }

        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        helper(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }
}
