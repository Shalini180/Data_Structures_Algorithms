class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = (len/2) + (len%2);
        for(int i = m; i < nums1.length;i++)
            nums1[i] = nums2[i - m];
        
        while(gap > 0) {
            int left = 0;
            int right = left + gap;
            while(right < len) {
                if(nums1[left] > nums1[right]) {
                    int temp = nums1[left];
                    nums1[left] = nums1[right];
                    nums1[right] = temp;
                }

                left++;
                right++;
            }

            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
    }
}
