class Solution {
    public int helper(int[] nums) {
        int left = 0, right = nums.length - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midEle = nums[mid];
            //System.out.println(nums[left] +" " + nums[right] + " " + midEle);
            if (midEle == 0) {
                ans = mid;
                right = mid - 1;
            } else if (midEle < 0) {
                left = mid + 1;
            } else {
                ans = mid;
                right = mid - 1;
            }
        }
        return ans;
    }

    public int maximumCount(int[] nums) {
        int pos = helper(nums);
        int n = nums.length;
         if(pos == -1){
            return n;
        }
        int positive = pos;
        while (positive < n) {
            if (nums[positive] != 0)
                break;
            positive++;
        }
        return Math.max(pos, n - positive);
    }
}
