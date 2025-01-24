class Solution {
    public boolean isSubsequence(String s, String t) {

        // Edgecase
        int sLength = s.length();
        int tLength = t.length();

        if (sLength > tLength) {
            return false;
        } else if (sLength == tLength && !s.equals(t)) {
            return false;
        }

        // If we can find all of the characters in s in order
        // in t, then s is a subsequence of t
        int sPoint = 0;
        int tPoint = 0;
        while (tPoint < tLength && sPoint < sLength) {
            if (s.charAt(sPoint) == t.charAt(tPoint)) {
                sPoint++;
            }

            tPoint++;
        }

        return sPoint >= sLength;
    }
}