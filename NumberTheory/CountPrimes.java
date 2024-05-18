class Solution {
    public int count(int n) {
        Boolean[] isPrime = new Boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        if (n >= 1) isPrime[1] = false;
        
        int c = 0;
        int k = 0;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i] == false) continue;
            c += 1;
            for (int j = i * i; j <= n; j += i) {
                isPrime[j] = false;
            }
            k = i;
        }
        
        for (int j = k + 1; j < n; j++) {
            if (isPrime[j] == true) c += 1;
        }

        return c;
    }

    public int countPrimes(int n) {
        return count(n);
    }
}
