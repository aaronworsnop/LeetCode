class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        // Edgecases
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        // Capture the the frequency of all characters that appear in
        // `magazine`
        int[] characterFrequency = new int[26];

        for (char character : magazine.toCharArray()) {
            characterFrequency[character - 'a']++;
        }

        // Check if we have the right letters to construct `ransomNote`
        for (char character : ransomNote.toCharArray()) {
            int currentMagazineCount = --characterFrequency[character - 'a'];

            if (currentMagazineCount < 0) {
                return false;
            }
        }

        return true;
    }
}