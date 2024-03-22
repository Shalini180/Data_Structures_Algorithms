class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            int midElement = nums[mid];
            if(midElement == target){
                return mid;
            }
            else if(midElement > target){
                right = mid - 1;
            }
            else if(midElement < target){
                left = mid + 1;
            }
        }

        return -1;
    }
}
