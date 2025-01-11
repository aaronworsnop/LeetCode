class Solution {
    public int hIndex(int[] citations) {
        // First sort the array
        int hIndex = 0;
        Arrays.sort(citations);

        int paper = 0;
        int totalLength = citations.length;

        while (paper < totalLength) {
            int height = citations[paper];
            int length = totalLength - paper;

            hIndex = Math.max(hIndex, Math.min(height, length));
            paper++;
        }

        return hIndex;
    }
}