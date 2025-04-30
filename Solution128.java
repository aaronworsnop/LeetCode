class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int longest = 0;

        for (int num : numSet) {
            // We only want to start from the beginning 
            if (numSet.contains(num - 1)) continue;

            int currentNum = num;
            int streak = 1;
            while (numSet.contains(currentNum + 1)) {
                streak++;
                currentNum++;
            }

            longest = Math.max(longest, streak);
        }

        return longest;
    }
}
