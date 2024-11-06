class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int first = 0;
        int second = numbers.length - 1;
        int[] ans = new int[2];
        while(first <= second){
            int sum = numbers[first] + numbers[second];
            if(sum == target) {
                ans[0] = first + 1;
                ans[1] = second + 1;
                return ans;
            }

            if(sum < target) first++;
            else second--;
        }

        return ans;
    }
}
