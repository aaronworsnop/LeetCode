class Solution72 {
    public int minDistance(String word1, String word2) {
        // sea -> seahorse
        // house -> horse
        // bread -> infinity
        // plonk -> a

        // Insert | Delete | Replace

        // Worst case, it takes `longestWord.length()` operations

        // DP row is word1, col is word2

        // [s: 0, e: 1, a: 2]
        // 
        if (word1 == null || word2 == null) {
            return -1;
        } else if (word1.length() == 0 && word2.length() == 0) {
            return 0;
        }

        int[][] cache = new int[word1.length() + 1][word2.length() + 1];

        // Initialise cache
        for (int i = 0; i < cache.length; i++) {
            for (int j = 0; j < cache[0].length; j++) {
                cache[i][j] = Integer.MAX_VALUE;
            }
        }

        // Initialise base cases
        for (int i = 0; i < cache.length; i++) {
            cache[i][cache[0].length - 1] = cache.length - 1 - i;
        }

        for (int i = 0; i < cache[0].length; i++) {
            cache[cache.length - 1][i] = cache[0].length - 1 - i;
        }

        // 
        for (int row = word1.length() - 1; row >= 0; row--) {
            for (int col = word2.length() - 1; col >= 0; col--) {
                char word1char = word1.charAt(row);
                char word2char = word2.charAt(col);

                if (word1char == word2char) {
                    cache[row][col] = cache[row + 1][col + 1];
                } else {
                    cache[row][col] = 1 + Math.min(Math.min(cache[row + 1][col], cache[row][col + 1]), cache[row + 1][col + 1]);
                }
            }
        }

        return cache[0][0];
    }
}