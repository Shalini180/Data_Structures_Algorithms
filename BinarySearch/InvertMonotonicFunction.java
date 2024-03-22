public class Main {
    public static int sumDigits(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number;
            number = number / 10;
        }
        return sum;
    }

    public static void linearHelper(int targetSum) {
        for (int i = 0; i < 10000000; i++) {
            if (sumDigits(i) == targetSum) {
                System.out.println("Linear Helper " + i);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void binaryHelper(int targetSum) {
        int start = 0, end = targetSum;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midSum = sumDigits(mid);
            if (midSum == targetSum) {
                System.out.println("Binary Helper " + mid);
                return;
            } else if (midSum > targetSum) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) {
        int targetSum = 1370;
        binaryHelper(targetSum);
        linearHelper(targetSum);
    }
}
