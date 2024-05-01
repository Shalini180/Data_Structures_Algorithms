class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> q = new LinkedList<>();
        int i = 0, j = 0, c = 0;
        while(j < n){
            int ele = nums[j];
            while(q.size() > 0 && nums[q.getLast()] <= ele)
                q.removeLast();
            q.addLast(j);

            if(j - i + 1 < k) j++;
            else{
                ans[c++] = nums[q.getFirst()];
                if(i >= q.getFirst()){
                    while(q.size() > 0 && q.getFirst() <= i) q.removeFirst();
                }

                i++;j++;
            }
        }

        return ans;
    }
}
