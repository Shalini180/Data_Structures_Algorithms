class Solution {
    public int search(int it, Set<Integer> hash) {
        int cnt = 1;
        int lastSmall = it;
        while(true) {
            if(hash.contains(lastSmall +1)){
                cnt ++;
                lastSmall = lastSmall + 1;
            }
            else{
                break;
            }
        }

        return cnt;
    }
    public int hashHelper(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int it : nums) hash.add(it);

        int ans = Integer.MIN_VALUE;
        for(int it : nums) {
            if(!hash.contains(it - 1)) {
                ans = Math.max(ans, search(it, hash));
            }
        }

        return ans;
    }
    public int longestConsecutive(int[] nums) {
        return hashHelper(nums);
    }
}
