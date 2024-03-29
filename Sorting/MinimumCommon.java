class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int minimum = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int n = nums1.length, m = nums2.length;
        
        while (i < n && j < m) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            }
        }

        return -1;
    }
}
