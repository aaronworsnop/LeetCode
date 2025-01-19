class Solution {
    public int romanToInt(String s) {

        // Edgecases
        if (s == null || s.length() == 0) {
            return 0;
        }

        int value = 0;

        // Create a mapping of roman to hindu-arabic numerals
        Map<Character, Integer> numeralMap = new HashMap<>();
        numeralMap.put('I', 1);
        numeralMap.put('V', 5);
        numeralMap.put('X', 10);
        numeralMap.put('L', 50);
        numeralMap.put('C', 100);
        numeralMap.put('D', 500);
        numeralMap.put('M', 1000);

        Stack<Character> numeralStack = new Stack<>();
        for (char c : s.toCharArray()) {
            numeralStack.push(c);
        }

        Character previousNumeral = 'I'; // Set to a value that no Roman numeral is less than
        while (!numeralStack.isEmpty()) {
            Character currentNumeral = numeralStack.pop();

            int currentNumeralValue = numeralMap.get(currentNumeral);

            if (currentNumeralValue < numeralMap.get(previousNumeral)) {
                value -= currentNumeralValue;
            } else {
                value += currentNumeralValue;
            }

            previousNumeral = currentNumeral;
        }

        return value;
    }
}