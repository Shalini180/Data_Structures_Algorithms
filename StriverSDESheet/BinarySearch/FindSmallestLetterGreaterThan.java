class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int n = letters.length;
        if((target + 'a') > (letters[n - 1] + 'a')) return letters[0];
        int low = 0, high = n - 1;
        char ans = letters[0];
        while(low <= high){
            int mid = (low + high)/2;
            if((target + 'a') < (letters[mid] + 'a')){
                high = mid - 1;
                ans = letters[mid];
            }
            else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
