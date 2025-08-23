public class LongestCommonPrefixFinder {

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String prefix = strs[0]; // start with the first string as prefix

        for (int i = 1; i < strs.length; i++) {
            // Reduce prefix until it matches current string
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        // Test Cases
        String[][] testCases = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"apple", "ape", "april"},
            {""},
            {"alone"},
            {}
        };

        for (int i = 0; i < testCases.length; i++) {
            String result = longestCommonPrefix(testCases[i]);
            System.out.println("Test Case " + (i + 1) + " → \"" + result + "\"");
        }
    }
}
