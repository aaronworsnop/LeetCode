class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        if (nums.empty()) {
            return 0;
        }
        
        int currentNumber = nums[0]; 
        int currentNumberCount = 0; 
        int newIndex = 0; 
        int originalIndex = 0; 

        while (originalIndex < nums.size()) {
            if (nums[originalIndex] == currentNumber) {
                currentNumberCount++;
            } else {
                currentNumberCount = 1;
                currentNumber = nums[originalIndex];
            }

            // Find next unique number
            if (currentNumberCount > 2) {
                while (originalIndex < nums.size() && nums[originalIndex] == currentNumber) {
                    originalIndex++;
                }
                
                if (originalIndex < nums.size()) {
                    currentNumber = nums[originalIndex];
                    currentNumberCount = 1;
                }
            }

            if (originalIndex >= nums.size()) {
                break;
            }
            
            // Build new array in place
            nums[newIndex] = nums[originalIndex];
            originalIndex++;
            newIndex++;
        }

        return newIndex;
    }
};