class Solution {
    public int minMaxWeight(int n, int[][] edges, int threshold) {
        // The threshold doesn't matter

        // Find the highest edge weight
        int maxWeight = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            maxWeight = Math.max(maxWeight, edge[2]);
        }

        // Create a reverse adjacency list of the graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            int weight = edge[2];

            List<Integer> currentAdj = graph.getOrDefault(end, new ArrayList<>());
            currentAdj.add(start);
            currentAdj.add(weight);

            graph.put(end, currentAdj);
        }

        int answer = -1;
        int lower = 0;
        int upper = maxWeight;
        int mid = lower + (upper - lower) / 2;
        while (lower <= upper) {
            mid = lower + (upper - lower) / 2;
            if (allReachZero(n, graph, mid)) {
                upper = mid - 1;
                answer = mid;
            } else lower = mid + 1;
        }

        return answer;
    }

    private boolean allReachZero(int n, Map<Integer, List<Integer>> graph, int maxWeight) {
        Set<Integer> seen = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        seen.add(0);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int node = 0; node < levelSize; node++) {
                List<Integer> adj = graph.get(queue.poll());

                if (adj == null) continue;
                for (int i = 0; i < adj.size(); i += 2) {
                    int end = adj.get(i);
                    int weight = adj.get(i + 1);

                    if (!seen.contains(end) && weight <= maxWeight) {
                        seen.add(end);
                        queue.add(end);
                    }
                }
            }
        }

        return seen.size() == n;
    }
}