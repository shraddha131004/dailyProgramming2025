import java.util.*;

public class ZeroSumSubarrays {
    public static List<int[]> findSubarraysWithZeroSum(int[] arr) {
        int prefixSum = 0;
        Map<Integer, List<Integer>> sumMap = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        
        // Initialize with prefix sum 0 at index -1
        sumMap.put(0, new ArrayList<>());
        sumMap.get(0).add(-1);
        
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            
            if (sumMap.containsKey(prefixSum)) {
                List<Integer> indices = sumMap.get(prefixSum);
                for (int start : indices) {
                    result.add(new int[]{start + 1, i});
                }
                indices.add(i);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                sumMap.put(prefixSum, newList);
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] arr1 = {1, 2, -3, 3, -1, 2};
        List<int[]> result1 = findSubarraysWithZeroSum(arr1);
        System.out.println("Output for [1, 2, -3, 3, -1, 2]:");
        for (int[] pair : result1) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
        
        int[] arr2 = {4, -1, -3, 1, 2, -1};
        List<int[]> result2 = findSubarraysWithZeroSum(arr2);
        System.out.println("\nOutput for [4, -1, -3, 1, 2, -1]:");
        for (int[] pair : result2) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
        
        int[] arr3 = {1, 2, 3, 4};
        List<int[]> result3 = findSubarraysWithZeroSum(arr3);
        System.out.println("\nOutput for [1, 2, 3, 4]:");
        if (result3.isEmpty()) {
            System.out.println("[]");
        }
        
        int[] arr4 = {0, 0, 0};
        List<int[]> result4 = findSubarraysWithZeroSum(arr4);
        System.out.println("\nOutput for [0, 0, 0]:");
        for (int[] pair : result4) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
        
        int[] arr5 = {-3, 1, 2, -3, 4, 0};
        List<int[]> result5 = findSubarraysWithZeroSum(arr5);
        System.out.println("\nOutput for [-3, 1, 2, -3, 4, 0]:");
        for (int[] pair : result5) {
            System.out.println("(" + pair[0] + ", " + pair[1] + ")");
        }
    }
}
