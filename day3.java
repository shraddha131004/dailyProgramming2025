public class DuplicateNumberFinder {

    public static int findDuplicate(int[] arr) {
        // Step 1: Detect cycle
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // Step 2: Find the duplicate
        slow = arr[0];
        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        return slow; // Duplicate number
    }

    public static void main(String[] args) {
        // Test Cases
        int[][] testCases = {
            {1, 3, 4, 2, 2},
            {3, 1, 3, 4, 2},
            {1, 1},
            {1, 4, 4, 2, 3},
            createLargeTestCase() // edge case for n=100000
        };

        for (int i = 0; i < testCases.length; i++) {
            int dup = findDuplicate(testCases[i]);
            System.out.println("Test Case " + (i + 1) + " → Duplicate number: " + dup);
        }
    }

    // Helper to generate large test case
    private static int[] createLargeTestCase() {
        int n = 100000;
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i - 1] = i;
        }
        arr[n] = 50000; // duplicate at the end
        return arr;
    }
}
