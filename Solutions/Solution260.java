class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        
        int[] singles = new int[2];
        int index = 0;
        for (int num : freqMap.keySet()) {
            if (freqMap.get(num) == 1) {
                singles[index++] = num;
            }
        }
        
        return singles;
    }
}
