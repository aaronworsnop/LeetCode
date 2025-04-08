class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder builder = new StringBuilder();

        int length = Math.min(word1.length(), word2.length());
        for (int i = 0; i < length; i++) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }

        if (word1.length() > length) {
            builder.append(word1.substring(length, word1.length()));
        } else if (word2.length() > length) {
            builder.append(word2.substring(length, word2.length()));
        }

        return builder.toString();
    }
}
