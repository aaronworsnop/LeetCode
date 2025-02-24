class MagicDictionary {
    private Map<String, Set<String>> wildcardDictionary;

    public MagicDictionary() {
        this.wildcardDictionary = new HashMap<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            for (int index = 0; index < word.length(); index++) {
                String magic = word.substring(0, index) + "*" + word.substring(index + 1, word.length());
                Set<String> normalWordsOfMagic = wildcardDictionary.getOrDefault(magic, new HashSet<>());
                normalWordsOfMagic.add(word);
                wildcardDictionary.put(magic, normalWordsOfMagic);
            }
        }
    }
    
    public boolean search(String searchWord) {
        for (int index = 0; index < searchWord.length(); index++) {
            String magic = searchWord.substring(0, index) + "*" + searchWord.substring(index + 1, searchWord.length());
            if (wildcardDictionary.containsKey(magic)) {
                Set<String> possibleWords = wildcardDictionary.get(magic);
                if (possibleWords.size() > 1 || !possibleWords.contains(searchWord)) return true;
            }
        }

        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */