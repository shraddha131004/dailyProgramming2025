import java.util.*;

public class LeadersInArray {

    public static List<Integer> findLeaders(int[] arr) {
        List<Integer> leaders = new ArrayList<>();
        int n = arr.length;

        int maxFromRight = arr[n - 1];
        leaders.add(maxFromRight);  // last element is always a leader

        // Traverse from second last to first
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                leaders.add(arr[i]);
                maxFromRight = arr[i];
            }
        }

        // Leaders are collected in reverse order → reverse them
        Collections.reverse(leaders);
        return leaders;
    }

    public static void main(String[] args) {
        // Test Cases
        int[][] testCases = {
            {16, 17, 4, 3, 5, 2},
            {1, 2, 3, 4, 0},
            {7, 10, 4, 10, 6, 5, 2},
            {5},
            {100, 50, 20, 10},
            {1, 2, 3, 1000000}  // large edge case representation
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + " → Leaders: " + findLeaders(testCases[i]));
        }
    }
}
