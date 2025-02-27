class Solution {
    private List<List<Integer>> powerSet;
    private int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.powerSet = new ArrayList<>();
        this.nums = nums;

        // Sorting helps remove duplicates
        Arrays.sort(this.nums);

        // Backtrack to find all subsets
        findSubsets(new LinkedList<>(), 0);
        return powerSet;
    }

    private void findSubsets(LinkedList<Integer> currentSubset, int index) {
        powerSet.add(new ArrayList(currentSubset));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) continue;

            currentSubset.add(nums[i]);
            findSubsets(currentSubset, i + 1);
            currentSubset.removeLast();
        }
    }
}