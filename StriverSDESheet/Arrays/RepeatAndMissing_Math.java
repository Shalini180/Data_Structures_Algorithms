import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // Function to calculate the sum of elements in the list using BigInteger
    public BigInteger summation(List<Integer> a) {
        BigInteger s = BigInteger.ZERO;
        for (int it : a) {
            s = s.add(BigInteger.valueOf(it));  // Add each element as a BigInteger
        }
        return s;
    }

    // Function to calculate the sum of squares of elements in the list using BigInteger
    public BigInteger summationSquares(List<Integer> a) {
        BigInteger s = BigInteger.ZERO;
        for (int it : a) {
            s = s.add(BigInteger.valueOf(it).multiply(BigInteger.valueOf(it)));  // Add square as BigInteger
        }
        return s;
    }

    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int n = A.size();
        
        // Convert to BigInteger to avoid overflow
        BigInteger SN = BigInteger.valueOf(n * (n + 1) / 2);
        BigInteger S2N = BigInteger.valueOf(n * (n + 1) * (2 * n + 1) / 6);

        BigInteger S = summation(A);
        BigInteger S2 = summationSquares(A);

        // Calculate xMinusY = S - SN
        BigInteger xMinusY = S.subtract(SN);

        // Calculate xPlusY = S2 - S2N
        BigInteger xPlusY = S2.subtract(S2N);

        // Find x + y = (x^2 - y^2) / (x - y)
        xPlusY = xPlusY.divide(xMinusY);

        // Find repeating and missing numbers
        BigInteger repeatingNumber = xMinusY.add(xPlusY).divide(BigInteger.valueOf(2));
        BigInteger missingNumber = repeatingNumber.subtract(xMinusY);

        // Convert to int before returning
        ArrayList<Integer> answer = new ArrayList<>(Arrays.asList(repeatingNumber.intValue(), missingNumber.intValue()));
        return answer;
    }
}
