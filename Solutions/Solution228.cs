public class Solution {
    public IList<string> SummaryRanges(int[] nums) {
        if (nums.Length == 0) 
        {
            return new List<string>();
        }

        var ranges = new List<string>();
        int rangeStart = nums[0];

        for (int index = 0; index < nums.Length; index++)
        {
            if (index == nums.Length - 1 || nums[index + 1] != nums[index] + 1)
            {
                if (rangeStart == nums[index])
                {
                    ranges.Add(rangeStart.ToString());
                }
                else
                {
                    ranges.Add(rangeStart.ToString() + "->" + nums[index].ToString());
                }

                if (index + 1 < nums.Length)
                {
                    rangeStart = nums[index + 1];
                }
            }
        }

        return ranges;
    }
}