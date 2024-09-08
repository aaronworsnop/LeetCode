class Solution205 {
    public boolean isIsomorphic(String s, String t) {
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
}