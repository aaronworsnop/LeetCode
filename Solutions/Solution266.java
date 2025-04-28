class Solution {
    public boolean canPermutePalindrome(String s) {
        // odd length: the frequency of all letters must be even except one
        // even: frequencies must all be even
        if (s.length() <= 1) {
            return true;
        }
        
        // Count the frequency of all letters
        Map<Character, Integer> letterFreq = new HashMap<>();
        for (char c : s.toCharArray()) {
            letterFreq.put(c, letterFreq.getOrDefault(c, 0) + 1);
        }
        
        boolean even = s.length() % 2 == 0;
        if (even) {
            for (int freq : letterFreq.values()) {
                if (freq % 2 == 1) return false;
            }
        } else {
            boolean seenOdd = false;
            for (int freq : letterFreq.values()) {
                if (freq % 2 == 1) {
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