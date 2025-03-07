class Solution {
    public boolean helper(int[] position, int force, int m) {
        int currCount = 1; int last = position[0];
        for(int i = 1; i < position.length;i++){
            if(position[i] - last >= force) {
                currCount++;
                last = position[i];
            }
            if(currCount >= m) return true;
        }

        return false;
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int low = 1, high = position[position.length - 1] - position[0];
        int ans = 0;
        while(low <= high) {
            int mid = (low + high)/2;
            if(helper(position, mid, m) == true){
                ans = mid;
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }

        return ans;
    }
}
