class Solution {
    public int countCompleteSubarrays(int[] nums) {
        // how many distinct numbers are there?
        // 1, 1, 2, 3, 3, 3
        // ^     ^
        int completeCount = 0;

        // Count how many distinct numbers there are
        Set<Integer> numSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numSet.add(nums[i]);
        }
        int distinct = numSet.size();

        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        int right = 0;

        while (left < nums.length - distinct + 1) {
            if (left > 0) {
                int remove = nums[left - 1];

                freqMap.put(remove, freqMap.get(remove) - 1);
                if (freqMap.get(remove) == 0) {
                    freqMap.remove(remove);
                }
            }

            while (right < nums.length && freqMap.size() < distinct) {
                int add = nums[right];

                freqMap.put(add, freqMap.getOrDefault(add, 0) + 1);
                right++;
            }

            if (freqMap.size() == distinct) {
                completeCount += (nums.length - right + 1);
            }

            left++;
        }

        return completeCount;
    }
}