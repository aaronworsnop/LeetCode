class Solution334 {
    public boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int[] leftMin = new int[nums.length];
        int[] rightMax = new int[nums.length];

        // Populate arrays representing what the maximum and minimum numbers
        // at each index are
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[nums.length - 1 - i]);

            leftMin[i] = min;
            rightMax[nums.length - 1 - i] = max;
        }

        // Check if there is an index at which an increasing triplet exists
        for (int i = 0; i < nums.length; i++) {
            if (leftMin[i] < nums[i] && nums[i] < rightMax[i]) {
                return true;
            }
        }

        return false;
    }
}