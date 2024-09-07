class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {

        // Edgecases
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Capture the the frequency of all characters that appear in
        // `magazine`
        Map<Character, Integer> characterMap = new HashMap<>();

        for (char character : magazine.toCharArray()) {
            int currentCharacterCount = characterMap.getOrDefault(character, 0);
            characterMap.put(character, currentCharacterCount + 1);
        }

        // Check if we have the right letters to construct `ransomNote`
        for (char character : ransomNote.toCharArray()) {
            int currentMagazineCount = characterMap.getOrDefault(character, 0);

            if (currentMagazineCount < 1) {
                return false;
            }

            characterMap.put(character, currentMagazineCount - 1);
        }

        return true;
    }
}