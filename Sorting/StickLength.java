import java.util.*;

public class Main {
    public static long helper(long[] arr, int n) {
        Arrays.sort(arr);
        long[] prefix = new long[n];
        for (int i = 0; i < n; i++) {
            prefix[i] = (i == 0) ? arr[0] : arr[i] + prefix[i - 1];
        }
        long mini = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long left = i * arr[i];
            left -= (i == 0) ? 0 : prefix[i - 1];
            long right = prefix[n - 1] - prefix[i] - (n - i - 1) * arr[i];
            long total = left + right;
            mini = Math.min(mini, total);
        }

        return mini;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        System.out.println(helper(arr, n));
    }
}
