class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] range = new int[2];
        Arrays.fill(range, -1);
        int low = 0, high = n - 1;
        while(low <= high){
            int mid = (low + high)/2;
            if(nums[mid] == target){
                int i = mid, j = mid;
                while(i >= 0 && nums[i] == target)i--;
                while(j < n && nums[j] == target) j++;
                range[0] = i + 1;
                range[1] = j - 1;
                return range;
            }
            else if(target < nums[mid]) high = mid - 1;
            else low = mid + 1;
        }

        return range;
    }
}
