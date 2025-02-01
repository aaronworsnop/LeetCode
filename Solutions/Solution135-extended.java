/**
 * This is a solution to a problem similar to Question 135 Candy.
 * 
 * In this version, each child must get more candies than ALL children
 * who have ratings below them. 
 */
class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        } else if (ratings.length == 1) {
            return 1;
        }

        // Order ratings by lowest
        PriorityQueue<Integer> ratingHeap = new PriorityQueue<>();
        Set<Integer> ratingSet = new HashSet<>();

        for (int rating : ratings) {
            if (!ratingSet.contains(rating)) {
                ratingHeap.offer(rating);
                ratingSet.add(rating);
            }
        }

        // Create a mapping from a unique rating to a unique tier
        Map<Integer, Integer> ratingToTierMap = new HashMap<>();
        int currentTier = 1;

        while (!ratingHeap.isEmpty()) {
            ratingToTierMap.put(ratingHeap.poll(), currentTier++);
        }

        // Determine the minimum number of candies needed to satisfy
        // based on ratings. (Due to the implementation, this could
        // even have a multiplier applied.)
        int minCandies = 0;
        for (int rating : ratings) {
            minCandies += ratingToTierMap.get(rating);
        }

        return minCandies;
    }
}