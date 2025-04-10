class Solution {
    // [1, 3, 1]
    // prob: 1 -> 20%
    // prob: 3 -> 60%
    // prob: 1 -> 20%
    // [0, 1, 4]

    private int[] w;
    private int[] buckets;
    private int totalWeight;

    public Solution(int[] w) {
        this.w = w;
        this.buckets = new int[w.length];

        // Calculate total weight
        int totalWeight = 0;
        for (int i = 0; i < w.length; i++) {
            buckets[i] = totalWeight;
            totalWeight += w[i];
        }

        this.totalWeight = totalWeight;
    }
    
    public int pickIndex() {
        // This must be random, by weight
        int random = (int) (Math.random() * (totalWeight));

        // Binary search to find the correct bucket
        int left = 0;
        int right = buckets.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (buckets[mid] < random) {
                if (mid == buckets.length - 1 || buckets[mid + 1] > random) {
                    // Win condition
                    left = mid;
                    break;
                } else {
                    left = mid + 1;
                }
            } else if (buckets[mid] == random) {
                left = mid;
                break;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
