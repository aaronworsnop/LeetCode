class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, Set<int[]>> adjList = new HashMap<>();
        for (int[] flight : flights) {
            Set<int[]> edges = adjList.getOrDefault(flight[0], new HashSet<>());
            edges.add(new int[]{flight[1], flight[2]});
            adjList.put(flight[0], edges);
        }

        int[] stops = new int[n];
        Arrays.fill(stops, Integer.MAX_VALUE);
        // {node, price_from_src, stops_from_src}
        PriorityQueue<int[]> pq = new PriorityQueue<>( (edgeA, edgeB) -> edgeA[1] - edgeB[1]);
        pq.offer(new int[]{src, 0, 0});

        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int edgeDestination = edge[0];
            int priceFromSource = edge[1];
            int stopsFromSource = edge[2];
            
            if (stopsFromSource > stops[edgeDestination]) {
                // This is a stale edge entry if the stops are greater than our best yet
                continue;
            } 

            if (stopsFromSource > k + 1) {
                // The edge has more stops than our limit
                continue;
            }

            stops[edgeDestination] = stopsFromSource;

            if (edgeDestination == dst) {
                // Because we greedily pick the cheapest edge every time, once we reach the 
                // destination, we have the best path (only works with non-negative prices)
                return priceFromSource;
            }

            if (!adjList.containsKey(edgeDestination)) {
                // This is a sink node, no edges
                continue;
            }

            for (int[] otherEdge : adjList.get(edgeDestination)) {
                pq.add(new int[]{
                    otherEdge[0], priceFromSource + otherEdge[1], stops[edgeDestination] + 1
                });
            }
        }
        
        // We never reached the destination in less than or k stops
        return -1;
    }
}