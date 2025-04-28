class Solution {
    public int findLHS(int[] nums) {
        //  diff between max and min value is 1
        
        // subsequence is just in order, not contiguous
        
        // [3, 5, 2, 4, 3, 9, 11, 3, 1, 2]
        //  ^
        
        // 1/2 : 1
        // 2/3 : 2
        // 3/4 : 1
        // 4/5 : 1
        // 5/6 : 1
        
        // represent 1&2, 2&3 in a hashmap, and count the frequency
        // of these numbers
        
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        Map<Integer, Integer> harmoFreq = new HashMap<>();
        Set<Integer> numSet = new HashSet<>();
        
        for (int num : nums) {
            harmoFreq.put(num, harmoFreq.getOrDefault(num, 0) + 1);
            harmoFreq.put(num + 1, harmoFreq.getOrDefault(num + 1, 0) + 1);
            
            numSet.add(num);
        }
        
        int largestHarmoSubseq = 0;
        for (int num : harmoFreq.keySet()) {
            if (numSet.contains(num) && (numSet.contains(num - 1) || numSet.contains(num + 1))) {
                largestHarmoSubseq = Math.max(largestHarmoSubseq, harmoFreq.get(num));
            }
        }
        
        return largestHarmoSubseq;
    }
}