class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;

        int start = 0;
        int end = 0;
        int workingTotal = nums[0];
        while (start <= end && end < nums.length) {
            if (workingTotal < target) {
                end++;

                if (end >= nums.length)
                   
                    break;

                workingTotal += nums[end];
            } else {
                min = Math.min(min, end - start + 1);

                   
                if (start >= nums.length)
                    break;

                workingTotal -= nums[start];
                start++;
            }
        }

        return min == Integer.MAX_VALUE ? 0 : min;
    }
}