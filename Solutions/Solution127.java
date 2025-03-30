class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int length = beginWord.length();

        // Create a map of all reachable transforms from the words in our wordList
        Map<String, Set<String>> transformsMap = new HashMap<>();

        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                String transform = word.substring(0, i) + "_" + word.substring(i + 1, length);
                Set<String> transforms = transformsMap.getOrDefault(transform, new HashSet<>());
                transforms.add(word);
                transformsMap.put(transform, transforms);
            }
        }

        // BFS
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(beginWord, 1));

        Map<String, Boolean> visited = new HashMap<>();
        visited.put(beginWord, true);

        while (!queue.isEmpty()) {
            Pair<String, Integer> node = queue.poll();
            String word = node.getKey();
            int level = node.getValue();

            for (int i = 0; i < length; i++) {
                // Transform of the current word
                String nextWord = word.substring(0, i) + "_" + word.substring(i + 1, length);

                Set<String> transforms = transformsMap.getOrDefault(nextWord, new HashSet<>());
                for (String transform : transforms) {
                    if (transform.equals(endWord)) {
                        return level + 1;
                    }

                    if (!visited.getOrDefault(transform, false)) {
                        visited.put(transform, true);
                        queue.add(new Pair<>(transform, level + 1));
                    }
                }
            }
        }

        return 0;
    }

    private boolean isTransform(String str1, String str2) {
        if (str1.equals(str2)) return true;
        if (str1.length() != str2.length()) return false;

        int numDiff = 0;
        int index = 0;
        while (index < str1.length()) {
            if (numDiff > 1) return false;

            if (str1.charAt(index) != str2.charAt(index)) {
                numDiff++;
            }

            index++;
        }

        return true;
    }
}