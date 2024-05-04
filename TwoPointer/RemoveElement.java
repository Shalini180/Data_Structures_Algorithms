class Solution {
    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        if(n == 1 && nums[0] == val) return 0;
        else if(n == 1 && nums[0] != val) return 1;
        int i = 0, j = n -1;
        while(i < n && i <= j){
            System.out.println(nums[i] + " " + i + " " + j);
            if(nums[i] == val){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j--;
            }
            else
                i++;
        }

        // System.out.println(j + " " + i);
        return i;
    }
}
