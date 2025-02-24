class Solution {
    public String removeKdigits(String num, int k) {
        // Prioritise larger digits towards the most significant digit for removal

        if (num.length() == k) {
            return "0";
        }

        // Populate a Monitonic Stack greedily, whilst removing digits according
        // to the condition above
        LinkedList<Character> stack = new LinkedList<>();
        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peekLast() > digit) {
                stack.removeLast();
                k--;
            }

            stack.addLast(digit);
        }

        // Remove tail-end digits in case we haven't removed k-digits yet
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }

        // Construct the final digit representation, removing leading zeros
        StringBuilder builder = new StringBuilder();
        boolean clearedLeadingZeros = false;
        for (char digit : stack) {
            if (!clearedLeadingZeros && digit == '0') continue;
            clearedLeadingZeros = true;
            builder.append(digit);
        }

        return builder.length() == 0 ? "0" : builder.toString();
    }
}