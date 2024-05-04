class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        int n = digits.length;
        for(int i = n-1;i>=0;i--){
            int currValue = digits[i];
            if(currValue != 9){
                digits[i] += 1;
                return digits;
            }
            else{
                digits[i] = 0;
                carry = 1;
            }
        }

        if(carry == 1){
            int[] newArray = new int[n+1];
            newArray[0] = 1;
            for(int i = 1;i<=n;i++){
                newArray[i] = digits[i-1];
            }

            return newArray;
        }

        return digits;
    }
}
