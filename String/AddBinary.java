class Solution {
    public String addBinary(String a, String b) {
        int carry = 0, s = 0;
        int n = a.length(), m = b.length();
        int i = n - 1, j = m - 1;
        StringBuilder str = new StringBuilder();
        
        while (i >= 0 || j >= 0) {
            if (i >= 0) s += a.charAt(i) - '0';
            if (j >= 0) s += b.charAt(j) - '0';
            s += carry;
            if (s == 0 || s == 1) {
                str.append((char)(s + '0'));
                carry = 0;
            } else if (s == 2) {
                str.append('0');
                carry = 1;
            } else if (s == 3) {
                str.append('1');
                carry = 1;
            }

            s = 0;
            i--;
            j--;
        }
        
        if (carry == 1) str.append('1');
        return str.reverse().toString();
    }
}
