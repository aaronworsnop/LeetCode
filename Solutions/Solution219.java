class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if (k <= 0) {
            return false;
        }

        Set<Integer> nearbyValues = new HashSet<>();
        Queue<Integer> window = new LinkedList<>();

        int index = 0;
        while (index < nums.length) {
            int num = nums[index];

            if (nearbyValues.contains(num)) {
                return true;
            }

            if (window.size() > k - 1)
                nearbyValues.remove(window.poll());
            window.offer(num);
            nearbyValues.add(num);

            index++;
        }

        return false;
    }
}