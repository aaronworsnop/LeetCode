class Solution {
    public int candy(int[] ratings) {

        if (ratings == null || ratings.length == 0) {
            return 0;
        } else if (ratings.length == 1) {
            return 1;
        }

        int[] candies = new int[ratings.length];

        // Each child should get at least one candy
        Arrays.fill(candies, 1);

        for (int child = 1; child < ratings.length; child++) {
            if (ratings[child] > ratings[child - 1]) {
                candies[child] += candies[child - 1];
            }
        }

        for (int child = ratings.length - 2; child >= 0; child--) {
            if (ratings[child] > ratings[child + 1]) {
                candies[child] = Math.max(candies[child], candies[child + 1] + 1);
            }
        }

        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }

        return sum;
    }
}