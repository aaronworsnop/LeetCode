class Solution {
    public int compress(char[] chars) {
        char consecutive = '.';
        int consecutiveLength = 1;

        int traverseIndex = 0;
        int compressIndex = 0;
        while (true) {
            if (traverseIndex == chars.length) {
                if (consecutiveLength > 1) {
                    String consecutiveLengthString = String.valueOf(consecutiveLength);
                    char[] consecutiveLengthCharacters = consecutiveLengthString.toCharArray();

                    for (char character : consecutiveLengthCharacters) {
                        chars[compressIndex++] = character;
                    }
                }

                break;
            }

            char current = chars[traverseIndex];

            if (current != consecutive) {
                consecutive = current;

                if (consecutiveLength > 1) {
                    String consecutiveLengthString = String.valueOf(consecutiveLength);
                    char[] consecutiveLengthCharacters = consecutiveLengthString.toCharArray();

                    for (char character : consecutiveLengthCharacters) {
                        chars[compressIndex++] = character;
                    }
                }

                chars[compressIndex++] = current;

                consecutiveLength = 1;
            } else {
                consecutiveLength++;
            }

            traverseIndex++;
        }

        return compressIndex;
    }
}
