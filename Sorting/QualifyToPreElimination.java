import java.util.*;

class Codechef {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int arrayLength = scanner.nextInt(); 
            int targetIndex = scanner.nextInt(); 
            Integer[] array = new Integer[arrayLength];
            
            for (int j = 0; j < arrayLength; j++) {
                array[j] = scanner.nextInt();
            }
            
            Arrays.sort(array, Comparator.reverseOrder());
            int targetElement = array[targetIndex - 1];
            int count = targetIndex;
            
            for (int j = targetIndex; j < arrayLength; j++) {
                if (array[j].equals(targetElement))
                    count++;
                else
                    break;
            }
            
            System.out.println(count);
        }
    }
}
