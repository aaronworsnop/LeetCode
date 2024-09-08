class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        s = convertToPattern(s);
        String t = pattern;

        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sCharacterMap = new HashMap<>();
        Map<Character, Integer> tCharacterMap = new HashMap<>();

        int sDigit = 0;
        int tDigit = 0;

        for (int i = 0; i < s.length(); i++) {
            char sCharacter = s.charAt(i);
            char tCharacter = t.charAt(i);

            int sCurrentDigit;
            int tCurrentDigit;

            if (sCharacterMap.containsKey(sCharacter)) {
                sCurrentDigit = sCharacterMap.get(sCharacter);
            } else {
                sCurrentDigit = sDigit;
                sCharacterMap.put(sCharacter, sDigit++);
            }

            if (tCharacterMap.containsKey(tCharacter)) {
                tCurrentDigit = tCharacterMap.get(tCharacter);
            } else {
                tCurrentDigit = tDigit;
                tCharacterMap.put(tCharacter, tDigit++);
            }

            if (sCurrentDigit != tCurrentDigit) {
                return false;
            }
        }

        return true;
    }

    public String convertToPattern(String s) {
        String[] wordList = s.split(" ");

        Map<String, Character> seenWords = new HashMap<>();
        int unique = 0;

        StringBuilder sb = new StringBuilder();

        for (String word : wordList) {
            char pattern = 'a';
            if (!seenWords.containsKey(word)) {
                sb.append((char) (pattern + unique));
                seenWords.put(word, (char) (pattern + unique++));
            } else {
                sb.append(seenWords.get(word));
            }
        }

        return sb.toString();
    }
}