public class MergeSortedArrays {

    // Function to merge two sorted arrays in-place
    public static void merge(int[] arr1, int[] arr2) {
        int m = arr1.length;
        int n = arr2.length;
        int gap = (m + n + 1) / 2; // initial gap

        while (gap > 0) {
            int i = 0, j = gap;

            while (j < (m + n)) {
                // Get values at i and j (handling arr1/arr2)
                int val1 = (i < m) ? arr1[i] : arr2[i - m];
                int val2 = (j < m) ? arr1[j] : arr2[j - m];

                // Swap if out of order
                if (val1 > val2) {
                    if (i < m && j < m) {
                        // both in arr1
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;
                    } else if (i < m && j >= m) {
                        // i in arr1, j in arr2
                        int temp = arr1[i];
                        arr1[i] = arr2[j - m];
                        arr2[j - m] = temp;
                    } else {
                        // both in arr2
                        int temp = arr2[i - m];
                        arr2[i - m] = arr2[j - m];
                        arr2[j - m] = temp;
                    }
                }
                i++;
                j++;
            }

            if (gap == 1) break;
            gap = (gap + 1) / 2; // reduce gap
        }
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] arr1 = {1, 3, 5};
        int[] arr2 = {2, 4, 6};
        merge(arr1, arr2);
        printArrays(arr1, arr2);

        // Test Case 2
        int[] arr3 = {10, 12, 14};
        int[] arr4 = {1, 3, 5};
        merge(arr3, arr4);
        printArrays(arr3, arr4);

        // Test Case 3
        int[] arr5 = {2, 3, 8};
        int[] arr6 = {4, 6, 10};
        merge(arr5, arr6);
        printArrays(arr5, arr6);

        // Edge Case
        int[] arr7 = {1};
        int[] arr8 = {2};
        merge(arr7, arr8);
        printArrays(arr7, arr8);
    }

    private static void printArrays(int[] arr1, int[] arr2) {
        System.out.print("arr1 = ");
        for (int x : arr1) System.out.print(x + " ");
        System.out.print(" | arr2 = ");
        for (int x : arr2) System.out.print(x + " ");
        System.out.println();
    }
}
