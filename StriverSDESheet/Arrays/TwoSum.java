class Pair{
    int element;
    int index;
    public Pair(int element, int index) {
        this.element = element;
        this.index = index;
    }
}
class Solution {
    public int[] hashHelper(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int remainingSum = target - nums[i];
            int count = mp.getOrDefault(remainingSum, -1);
            if(count != -1) {
                ans[0] = count;
                ans[1] = i;
                return ans;
            }

            mp.put(nums[i], i);
        }

        return ans;
    }
    public int[] twoPointer(int[] a, int target) {
        int left = 0;
        int right = a.length-1;
        Pair[] nums = new Pair[right + 1];
        for(int i = 0; i < a.length;i++){
            nums[i] = new Pair(a[i], i);
        }
        Arrays.sort(nums, (b, c) -> Integer.compare(b.element, c.element));
        while(left < right) {
            int sum = nums[left].element + nums[right].element;
            if(sum == target) return new int[]{nums[left].index, nums[right].index};
            else if(sum < target) left++;
            else right--;
        }

        return new int[]{};
    }
    public int[] twoSum(int[] nums, int target) {
        return hashHelper(nums, target);
    }
}
