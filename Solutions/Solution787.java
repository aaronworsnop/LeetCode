class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[src] = 0;

        int legs = 0;
        while (legs <= k) {
            int[] temp = Arrays.copyOf(distances, n);

            for (int[] flight : flights) {
                int flightSrc = flight[0];
                int flightDst = flight[1];
                int flightPrice = flight[2];

                if (distances[flightSrc] == Integer.MAX_VALUE) continue;

                temp[flightDst] = Math.min(temp[flightDst], distances[flightSrc] + flightPrice);
            }

            distances = temp;
            legs++;
        }

        return distances[dst] == Integer.MAX_VALUE ? -1 : distances[dst];
    }
}