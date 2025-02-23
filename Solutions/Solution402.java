class Solution {
    public String removeKdigits(String num, int k) {
        // Prioritise larger digits towards the most significant digit for removal

        if (num.length() == k) {
            return "0";
        }

        int index = 0;
        while (index < num.length() && k > 0) {
            if (index < 0) {
                index = 0;
            }

            if (index == num.length() - 1) {
                num = num.substring(0, index);
                index--;
                k--;
            } else if (num.charAt(index) > num.charAt(index + 1)) {
                num = num.substring(0, index) + num.substring(index + 1, num.length());
                index--;
                k--;
            } else {
                index++;
            }
        }

        // Remove leading 0s
        index = 0;
        while (index < num.length() && num.charAt(index) == '0') {
            index++;
        }

        if (index > 0) {
            num = num.substring(index);
        }

        return num.length() == 0 ? "0" : num;
    }
}