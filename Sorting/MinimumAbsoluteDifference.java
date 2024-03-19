class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        int diff = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length - 1; i++) {
            int currDiff = Math.abs(arr[i + 1] - arr[i]);
            if (currDiff < diff) {
                diff = currDiff;
                ans.clear();
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (currDiff == diff) {
                ans.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return ans;
    }
}
