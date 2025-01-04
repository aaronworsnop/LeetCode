class Solution {
    public int majorityElement(int[] nums) {

        // Testcase
        // 3, 3, 4, 4, 4
        // gf = 3
        // eogf = 4

        // 3, 2
        // 4, 3

        // Edgecases
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        }

        int greatestFrequency = 0;
        int elementOfGreatestFrequency = nums[0];

        Map<Integer, Integer> elementFrequencyMap = new HashMap<>();

        // Find the frequency of each element
        for (int index = 0; index < nums.length; index++) {
            int newFrequency = elementFrequencyMap.getOrDefault(nums[index], 0) + 1;
            elementFrequencyMap.put(nums[index], newFrequency);

            // Update the element of greatest frequency
            if (newFrequency > greatestFrequency) {
                elementOfGreatestFrequency = nums[index];
                greatestFrequency = newFrequency;
            }
        }

        return elementOfGreatestFrequency;
    }
}