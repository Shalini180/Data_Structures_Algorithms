class Solution {
    boolean hasArrayTwoCandidates(int arr[], int n, int x) {
        int m = 0;
        for (int it : arr) {
            m = Math.max(m, it);
        }
        
        int[] temp = new int[m + 1];
        Arrays.fill(temp, 0);

        for (int i = 0; i < n; i++) {
            int findEle = x - arr[i];
            if (findEle > 0 && findEle <= m && temp[findEle] != 0)
                return true;
            temp[arr[i]] += 1;
        }

        return false;
    }
}
