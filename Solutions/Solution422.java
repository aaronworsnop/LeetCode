class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Map<String, Set<String>> adjList = new HashMap<>();

        // Start with start
        for (String gene : bank) {
            if (isMutation(startGene, gene)) {
                Set<String> startAdjs = adjList.getOrDefault(startGene, new HashSet<>());
                startAdjs.add(gene);
                adjList.put(startGene, startAdjs);

                Set<String> geneAdjs = adjList.getOrDefault(gene, new HashSet<>());
                geneAdjs.add(startGene);
                adjList.put(gene, geneAdjs);
            }
        }

        // All the other genes in the gene bank
        for (String gene1 : bank) {
            for (String gene2 : bank) {
                if (gene1 != gene2 && isMutation(gene1, gene2)) {
                    Set<String> gene1Adjs = adjList.getOrDefault(gene1, new HashSet<>());
                    gene1Adjs.add(gene2);
                    adjList.put(gene1, gene1Adjs);
                    
                    Set<String> gene2Adjs = adjList.getOrDefault(gene2, new HashSet<>());
                    gene2Adjs.add(gene1);
                    adjList.put(gene2, gene2Adjs);
                }
            }
        }

        // BFS until we hit the end, return that distance
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);

        Set<String> visited = new HashSet<>();
        int distance = -1;
        while (!queue.isEmpty()) {
            distance++;
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; i++) {
                String currentGene = queue.poll();

                // Win condition
                if (currentGene.equals(endGene)) {
                    return distance;
                }

                Set<String> mutations = adjList.get(currentGene);
                if (mutations == null) continue;
                for (String mutation : mutations) {
                    if (visited.contains(mutation)) continue;
                    
                    visited.add(currentGene);
                    queue.offer(mutation);
                }
            }
        }

        return -1;
    }

    private static boolean isMutation(String g1, String g2) {
        boolean mutated = false;

        for (int i = 0; i < 8; i++) {
            if (g1.charAt(i) != g2.charAt(i)) {
                if (mutated == true) {
                    return false;
                } else {
                    mutated = true;
                }
            }
        }

        return true;
    }
}
