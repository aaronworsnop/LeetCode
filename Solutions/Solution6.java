class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() == 1) return s;

        StringBuilder builder = new StringBuilder();
        int length = s.length();
        int zLength = numRows * 2 - 2;

        for (int row = 0; row < numRows; row++) {
            int index = row;

            while (index < length) {
                builder.append(s.charAt(index));

                if (row != 0 && row != numRows - 1) {
                    int between = zLength - 2 * row;

                    if (index + between < length) {
                        builder.append(s.charAt(index + between));
                    }
                }

                index += zLength;
            }
        }
        
        return builder.toString();
    }
}
