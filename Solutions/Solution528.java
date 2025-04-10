class Solution {
    // [1, 3, 1]
    // prob: 1 -> 20%
    // prob: 3 -> 60%
    // prob: 1 -> 20%
    // [0, 1, 4]

    private int[] buckets;
    private int totalWeight;

    public Solution(int[] w) {
        this.buckets = new int[w.length];

        // Calculate total weight
        int totalWeight = 0;
        for (int i = 0; i < w.length; ++i) {
            totalWeight += w[i];
            buckets[i] = totalWeight;
        }

        this.totalWeight = totalWeight;
    }
    
    public int pickIndex() {
        // This must be random, by weight
        double random = Math.random() * totalWeight;

        // Binary search to find the correct bucket
        int left = 0;
        int right = buckets.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (buckets[mid] < random) left = mid + 1;
            else right = mid;
        }

        return left;
    }
}
