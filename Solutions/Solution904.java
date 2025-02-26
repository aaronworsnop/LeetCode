class Solution {
    public int totalFruit(int[] fruits) {
        int max = 0;
        
        Map<Integer, Integer> windowFruits = new HashMap<>();
        int left = 0;
        for (int right = 0; right < fruits.length; right++) {
            windowFruits.put(fruits[right], windowFruits.getOrDefault(fruits[right], 0) + 1);

            while (windowFruits.size() > 2) {
                windowFruits.put(fruits[left], windowFruits.get(fruits[left]) - 1);
                if (windowFruits.get(fruits[left]) == 0) {
                    windowFruits.remove(fruits[left]);
                }

                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}