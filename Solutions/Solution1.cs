public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        var dict = new Dictionary<int, int>();

        for (int index = 0; index < nums.Length; index++)
        {
            int complement = target - nums[index];

            if (dict.ContainsKey(complement))
            {
                return new int[] { dict[complement], index };
            }
            else
            {
                dict[nums[index]] = index;
            }
        }
        
        return Array.Empty<int>();
    }
}