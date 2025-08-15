import java.util.Arrays;

public class ZeroOneTwoSorter {

    public static void arrangeColors(int[] values) {
        if (values == null || values.length < 2) {
            return;
        }

        int leftPtr = 0;
        int scanPtr = 0;
        int rightPtr = values.length - 1;

        while (scanPtr <= rightPtr) {
            int current = values[scanPtr];

            if (current == 0) {
                if (scanPtr != leftPtr) {
                    swap(values, scanPtr, leftPtr);
                }
                leftPtr++;
                scanPtr++;
            } else if (current == 2) {
                if (scanPtr != rightPtr) {
                    swap(values, scanPtr, rightPtr);
                }
                rightPtr--;
            } else {
                scanPtr++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[][] testCases = {
            {0, 1, 2, 1, 0, 2, 1, 0},
            {1, 1, 1, 1},
            {2, 0, 1},
            {},
            {0, 0, 0, 0},
            {0, 1, 1, 2, 2}
        };

        for (int[] testCase : testCases) {
            arrangeColors(testCase);
            System.out.println(Arrays.toString(testCase));
        }
    }
}
