class Solution {
    public int lengthOfLastWord(String s) {
        int endIndex = s.length() - 1;

        char[] words = s.toCharArray();

        while (words[endIndex] == ' ') {
            endIndex--;
        }

        int lengthWord = 0;
        while (endIndex >= 0 && words[endIndex] != ' ') {
            lengthWord++;
            endIndex--;
        }

        return lengthWord;
    }
}
