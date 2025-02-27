class Solution {
    public int shortestWay(String source, String target) {
        // assume can use the same subsequence multiple times
        
        // if source doesn't contain all the letters in target, then
        // it's impossible
        
        // source: abc
        //         ^
        // target: abcbc
        //         ^
        
        // ONLY IF SUCCESSFUL
        // the number of times we look through `source` is the minimum
        // number of subsequences needed to created the target
        
        // if we ever go through source completely without finding a single match
        // there is no solution/'way'
        // in circular array -> (last match was over array.length ago)
        
        int subsequences = 0;
        
        int sourceIndex = 0;
        int targetIndex = 0;
        int lastMatch = 0;
        while (targetIndex < target.length()) {
            char sourceLetter = source.charAt(sourceIndex);
            char targetLetter = target.charAt(targetIndex);
            
            if (sourceLetter == targetLetter) {
                lastMatch = 0;
                targetIndex++;
            } else {
                lastMatch++;
            }
            
            if (sourceIndex == 0) {
                subsequences++;
            }
            
            sourceIndex = (sourceIndex + 1) % source.length();
            if (lastMatch >= source.length()) {
                return -1;
            }
        }
        
        return subsequences;
    }
}