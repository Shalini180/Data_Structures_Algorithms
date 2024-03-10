class Solution {
    int reverseNum;

    int sumOfDigits(int n) {
        if (n <= 0)
            return 0;

        return (n % 10) + (sumOfDigits(n / 10));
    }

    void reverseSum(int n) {
        if (n == 0)
            return;
        
        int lastDigit = n % 10;
        reverseNum = reverseNum * 10 + lastDigit;
        reverseSum(n / 10);
    }

    int isDigitSumPalindrome(int n) {
        int sum = sumOfDigits(n);
        reverseSum(sum);
        
        if (sum == reverseNum)
            return 1;
        
        return 0;
    }
}
