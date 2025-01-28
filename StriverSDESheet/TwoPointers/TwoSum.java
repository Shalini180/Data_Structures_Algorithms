class Solution {
    public int[] helper(int[] a, int k){
        int[] ans = new int[2];
        int i = 0, j = a.length - 1;
        while(i < j){
            int sum = a[i] + a[j];
            if(sum == k){
                ans[0] = i + 1; ans[1] = j + 1;
                return ans;
            }
            else if(sum < k) i++;
            else j--;
        }

        return ans;
    }
    public int[] twoSum(int[] numbers, int target) {
        return helper(numbers, target);
    }
}
