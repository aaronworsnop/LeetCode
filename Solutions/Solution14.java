class Solution {
    public String longestCommonPrefix(String[] strs) {

        // Edgecases
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        int maxPrefixLength = Integer.MAX_VALUE;
        for (String str : strs) {
            maxPrefixLength = Math.min(maxPrefixLength, str.length());
        }

        int longestPrefixLength = 0;

        prefixSearch: 
        for (int index = 0; index < maxPrefixLength; index++) {
            char commonCharacter = strs[0].charAt(index);

            for (int otherWord = 1; otherWord < strs.length; otherWord++) {
                if (strs[otherWord].charAt(index) != commonCharacter) {
                    break prefixSearch;
                }
            }

            longestPrefixLength++;
        }

        return strs[0].substring(0, longestPrefixLength);
    }
}