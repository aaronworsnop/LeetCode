public class Solution {
    public bool CanJump(int[] nums) {
        int target = nums.Length - 1;
        
        for (int i = nums.Length - 1; i >= 0; i--) 
        {
            if (i + nums[i] >= target)
            {
                target = i;
            }
        }

        return target == 0;
    }
}