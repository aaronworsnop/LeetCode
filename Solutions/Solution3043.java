class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longestPrefix = 0;

        for (int num1 : arr1) {
            for (int num2 : arr2) {
                longestPrefix = Math.max(longestPrefix, longestCommonPrefix(num1, num2));
            }
        }

        return longestPrefix;
    }

    private int longestCommonPrefix(int num1, int num2) {
        String string1 = String.valueOf(num1);
        String string2 = String.valueOf(num2);

        int length = Math.min(string1.length(), string2.length());

        int index = -1;
        while (++index < length) {
            if (string1.charAt(index) != string2.charAt(index)) {
                break;
            }
        }

        return index;
    }
}