impl Solution {
    pub fn can_jump(nums: Vec<i32>) -> bool {
        let mut target = nums.len() - 1;

        for index in (0..nums.len()).rev() {
            if (index + (nums[index] as usize) >= target) {
                target = index;
            }
        }

        target < 1
    }
}