class Solution {
    public boolean isSubsequence(String s, String t) {

        // Edgecase
        if (s.length() > t.length()) {
            return false;
        } else if (s.length() == t.length() && !s.equals(t)) {
            return false;
        }

        int start = 0;
        int end = 0;
        while (end < t.length() && start < s.length()) {
            if (s.charAt(start) == t.charAt(end)) {
                start++;
            }

            end++;
        }

        if (start >= s.length()) {
            return true;
        }

        return false;
    }
}