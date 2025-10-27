public class Solution {
    public int Jump(int[] nums) {
        int target = nums.Length - 1;
        int numJumps = 0;

        while (target > 0) 
        {
            for (int jumpIndex = 0; jumpIndex < target; jumpIndex++) 
            {
                if (jumpIndex + nums[jumpIndex] >= target) 
                {
                    numJumps++;
                    target = jumpIndex;
                    continue;
                }
            }
        }

        return numJumps;
    }
}