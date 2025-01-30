class Solution {
    public void helper(int[] a, int k, List<List<Integer>> ans) {
        int n = a.length;
        for(int first = 0; first < (n - 3); first++){
            if(first > 0 && a[first] == a[first - 1]) continue;
            for(int second = first + 1; second < (n - 2); second++){
                if(second > (first + 1) && a[second] == a[second - 1]) continue;
                int i = second + 1;
                int j = n - 1;
                while(i < j){
                    long sum = a[first] + a[second];
                    sum += a[i];
                    sum += a[j];
                    if(sum == k){
                        ans.add(new ArrayList<>(Arrays.asList(a[first], a[second], a[i], a[j])));
                        i++;
                        j--;
                        while(i < j && a[i] == a[i-1])i++;
                        while(i < j && a[j] == a[j+1])j--;
                    }
                    else if(sum < k) i++;
                    else j--;
                }
            }
        }
    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        helper(nums, target, answer);
        return answer;
    }
}
