class Solution {
    public boolean canPermutePalindrome(String s) {
        // odd length: the frequency of all letters must be even except one
        // even: frequencies must all be even
        if (s.length() <= 1) {
            return true;
        }
        
        // Count the frequency of all letters
        int[] letterFreq = new int[128];
        for (char c : s.toCharArray()) {
            letterFreq[c]++;
        }
        
        boolean even = s.length() % 2 == 0;
        if (even) {
            for (int ascii = 65; ascii < 123; ascii++) {
                if (letterFreq[ascii] % 2 == 1) return false;
            }
        } else {
            boolean seenOdd = false;
            for (int ascii = 65; ascii < 123; ascii++) {
                if (letterFreq[ascii] % 2 == 1) {
                    if (seenOdd == true) {
                        return false;
                    } else {
                        seenOdd = true;
                    }
                }
            }
        }
        
        return true;
    }
}