public class MissingNumberFinder {

    public static int findMissing(int[] arr) {
        int n = arr.length + 1; // since one number is missing
        long expectedSum = (long) n * (n + 1) / 2; // use long to avoid overflow
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int) (expectedSum - actualSum);
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
            {1, 2, 4, 5},
            {2, 3, 4, 5},
            {1, 2, 3, 4},
            {1},
            createLargeTestCase() // edge case for n = 1_000_000
        };

        for (int i = 0; i < testCases.length; i++) {
            int missing = findMissing(testCases[i]);
            System.out.println("Test Case " + (i + 1) + " → Missing number: " + missing);
        }
    }

    // helper to generate a large test case with 999,999 elements
    private static int[] createLargeTestCase() {
        int n = 1_000_000;
        int[] arr = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            arr[i] = i + 1;
        }
        // Missing number will be n (1,000,000)
        return arr;
    }
}
