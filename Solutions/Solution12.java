class Solution {
    public String intToRoman(int num) {

        // Initialise roman-integer pairings
        int[] numeral = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

        StringBuilder romanBuilder = new StringBuilder();
        int pair = 12;
        while (num > 0) {
            for (int i = 0; i < num / numeral[pair]; i++) {
                romanBuilder.append(roman[pair]);
            }

            num %= numeral[pair--];
        }

        return romanBuilder.toString();
    }
}