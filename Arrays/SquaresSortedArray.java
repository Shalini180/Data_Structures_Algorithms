class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int positiveIndex = n, negativeIndex = -1;
        int[] sortedArray = new int[n];
        int i = 0;
        while(i<n){
            if(nums[i] >= 0){
                positiveIndex = i;
                break;
            }
            negativeIndex = i;
            i++;
        }
        i = 0;
        while(negativeIndex >=0 && positiveIndex < n){
            int posElement = nums[positiveIndex];
            int negElement = -1 * nums[negativeIndex];
            if(posElement <= negElement){
                sortedArray[i] = posElement * posElement;
                i++;
                positiveIndex++;
            }
            else{
                sortedArray[i] = negElement * negElement;
                i++;
                negativeIndex--;
            }
        }

        while(negativeIndex >= 0){
            sortedArray[i] = nums[negativeIndex] * nums[negativeIndex];
            i++;
            negativeIndex--;
        }
        while(positiveIndex < n){
            sortedArray[i] = nums[positiveIndex] * nums[positiveIndex];
            i++;
            positiveIndex++;
        }


        return sortedArray;
    }
}
