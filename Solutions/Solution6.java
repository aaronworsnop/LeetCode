class Solution {
    public String convert(String s, int numRows) {
        // First count how many zigs there are
        int length = s.length();

        if (numRows == 1 || length == 1 || length < numRows) return s;

        int mod = 2 * numRows - 2;
        int fullZigs = length / mod;

        // Find how many numbers in each row
        int[] rowLengths = new int[numRows];
        Arrays.fill(rowLengths, fullZigs * 2);
        rowLengths[0] = fullZigs;
        rowLengths[numRows - 1] = fullZigs;

        Map<Integer, Queue<Character>> rowMap = new HashMap<>();

        int row = 0;
        boolean down = true;
        for (int i = 0; i < length; i++) {
            if (row == 0) down = true;
            if (row == numRows - 1) down = false;

            Queue<Character> rowQueue = rowMap.getOrDefault(row, new LinkedList<>());
            rowQueue.offer(s.charAt(i));
            rowMap.put(row, rowQueue);

            row = down ? row + 1 : row - 1;
        }

        // Build the final string
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            Queue<Character> rowQueue = rowMap.get(i);
            while (!rowQueue.isEmpty()) {
                builder.append(rowQueue.poll());
            }
        }

        return builder.toString();
    }
}
