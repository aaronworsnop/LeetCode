class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (k <= 0) {
            return false;
        }

        Map<Integer, Integer> mostRecentPosition = new HashMap<>();

        for (int index = 0; index < nums.length; index++) {
            if (Math.abs(mostRecentPosition.getOrDefault((nums[index]), Integer.MAX_VALUE) - index) <= k) {
                return true;
            }

            mostRecentPosition.put(nums[index], index);
        }
        
        return false;
    }
}