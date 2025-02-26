class Solution {
    public int countWords(String[] words1, String[] words2) {
        int words = 0;

        Map<String, Integer> words1Frequency = new HashMap<>();
        Map<String, Integer> words2Frequency = new HashMap<>();

        for (String word : words1) {
            words1Frequency.put(word, words1Frequency.getOrDefault(word, 0) + 1);
        }

        for (String word : words2) {
            words2Frequency.put(word, words2Frequency.getOrDefault(word, 0) + 1);
        }

        System.out.println(words1Frequency);
        System.out.println(words2Frequency);

        for (Map.Entry<String, Integer> entry : words1Frequency.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();

            if (frequency == 1 && words2Frequency.getOrDefault(word, 0) == 1) {
                System.out.println(word);
                words++;
            }
        }

        return words;
    }
}