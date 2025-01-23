class Solution {
    public String reverseWords(String s) {
        // The O(1) space complexity solution would be to reverse the
        // entire string and then reverse each word in the string.

        // Edgecases
        if (s == null || s.length() == 0) {
            return "";
        }

        // Trim the string `s`
        s = s.trim();

        // Add words to a stack
        Stack<String> stack = new Stack<>();

        int start = 0;
        while (start < s.length()) {

            // Capture an entire word
            int end = start;
            while (end < s.length() && s.charAt(end) != ' ') {
                end++;
            }

            String word = s.substring(start, end);
            stack.push(word);

            // Move to the next word
            while (end < s.length() && s.charAt(end) == ' ') {
                end++;
            }

            start = end;
        }

        // Construct reversed order from stack
        StringBuilder wordBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            wordBuilder.append(stack.pop() + " ");
        }

        return (wordBuilder.deleteCharAt(wordBuilder.length() - 1)).toString();
    }
}