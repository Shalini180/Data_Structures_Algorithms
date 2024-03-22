class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        while(l <= r){
            int mid = (l + r)/2;
            int lastEle = nums[r];
            int currEle = nums[mid];
            if(target > lastEle && currEle <= lastEle)
                r = mid - 1;
            else if(target <= lastEle && currEle > lastEle)
                l = mid + 1;
            else{
                if(target == currEle)
                    return mid;
                else if(target > currEle)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }

        return -1;
    }
}
