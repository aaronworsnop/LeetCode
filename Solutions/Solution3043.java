class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longestPrefix = 0;

        // Compute all prefixes of the smaller array
        if (arr1.length < arr2.length) {
            int[] temp = arr1;
            arr1 = arr2;
            arr2 = temp;
        }

        Set<Integer> prefixes = new HashSet<>();

        for (int num : arr1) {
            while (num > 0) {
                prefixes.add(num);
                num /= 10;
            }
        }

        // Find the longest common prefix with the larger/second array
        for (int num : arr2) {
            int numLength = String.valueOf(num).length();

            while (numLength > longestPrefix) {
                if (prefixes.contains(num)) {
                    longestPrefix = numLength;
                    break;
                }
                
                num /= 10;
                numLength--;
            }
        }

        return longestPrefix;
    }
}