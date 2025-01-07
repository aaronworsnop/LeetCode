class Solution {
    public int jump(int[] nums) {
        // First find minimum need to reach 

        int minJumps = 0;

        if (nums.length < 2) {
            return minJumps;
        }

        int left = 0;
        int right = 0;

        while (right < nums.length - 1) {
            int furthestJump = 0;

            for (int i = left; i <= right; i++) {
                furthestJump = Math.max(furthestJump, i + nums[i]);
            }

            left = right + 1;
            right = furthestJump;
            minJumps++;
        }

        return minJumps;
    }
}