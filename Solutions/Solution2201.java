class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        // Create a map of each artifact to its components, for each dig, remove from hashmap
        // until empty, if empty then +

        int extractedArtifacts = 0;

        // (artifactIndex, .. [x, y] ..)
        Map<Integer, Set<String>> artifactMap = new HashMap<>();
        Map<String, Integer> cellMap = new HashMap<>();
        
        int artifactIndex = 0;
        for (int[] artifact : artifacts) {
            
            // The following is actually constant time, it can never be more than
            // 4 operations.
            int r1 = artifact[0];
            int c1 = artifact[1];
            int r2 = artifact[2];
            int c2 = artifact[3];

            Set<String> artifactCoordinates = artifactMap.getOrDefault(artifactIndex, new HashSet<>());
            for (int row = r1; row <= r2; row++) {
                for (int col = c1; col <= c2; col++) {
                    artifactCoordinates.add(row + "," + col);
                    cellMap.put(row + "," + col, artifactIndex);
                }
            }

            artifactMap.put(artifactIndex++, artifactCoordinates);
        }

        System.out.println(artifactMap);

        for (int[] cell : dig) {
            String key = cell[0] + "," + cell[1];

            if (cellMap.containsKey(key)) {
                int parentArtifact = cellMap.get(key);
                Set<String> artifactCells = artifactMap.get(parentArtifact);
                artifactCells.remove(key);

                if (artifactCells.size() == 0) {
                    extractedArtifacts++;
                    cellMap.remove(key);
                    artifactMap.remove(parentArtifact);
                } else {
                    artifactMap.put(parentArtifact, artifactCells);
                }
            }
        }

        return extractedArtifacts;
    }
}