class Solution {
    public boolean confusingNumber(int n) {
        // What is the pivot point?
        // Pivot around the centre
        // Ignore leading zeros
        
        // Not a confusing number:
        // Same number when rotated
        // Invalid number when rotated
        
        
        // Check for valid rotation
        if (!validRotation(n)) {
            return false;
        }
        
        String stringN = String.valueOf(n);
        
        // An odd length number with 6 or 9 in the middle must be confusing
        if (stringN.length() % 2 != 0) {
            char middleDigit = stringN.charAt(stringN.length() / 2);
            if (middleDigit == '6' || middleDigit == '9') {
                // This number must be confusing
                return true;
            }
        }
        
        Map<Character, Character> flipMap = new HashMap<>(Map.of('0', '0', 
                                                                 '1', '1', 
                                                                 '6', '9', 
                                                                 '8', '8', 
                                                                 '9', '6'));
        
        for (int index = 0; index < stringN.length() / 2; index++) {
            char mirrorLeft = stringN.charAt(index);
            char mirrorRight = stringN.charAt(stringN.length() - 1 - index);
            
            if (mirrorRight != flipMap.get(mirrorLeft)) {
                return true;
            }
        }
        
        return false;
    }
    
    private boolean validRotation(int n) {
        String stringN = String.valueOf(n);
        
        // Check for digits that don't rotate
        for (char c : stringN.toCharArray()) {
            switch (c) {
                case '2':
                case '3':
                case '4':
                case '5':
                case '7':
                    return false;
                default:
                    continue;
            }
        }
        
        return true;
    }
}