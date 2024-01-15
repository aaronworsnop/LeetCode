class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Find the topological ordering

        // First build adjacency list digraph representation
        // and the reverse
        Map<Integer, List<Integer>> reqGraph = new HashMap<>();
        Map<Integer, Integer> courseInDegree = new HashMap<>();

        for (int i = 0; i < numCourses; i++) {
            courseInDegree.put(i, 0);
        }

        for (int[] course : prerequisites) {
            // Put adjacency in graph
            List<Integer> courseAdjacencies = reqGraph.getOrDefault(course[1], new ArrayList<>());
            courseAdjacencies.add(course[0]);
            reqGraph.put(course[1], courseAdjacencies);

            // Update the in-degree map
            courseInDegree.put(course[0], courseInDegree.get(course[0]) + 1);
        }

        System.out.println(reqGraph);
        System.out.println(courseInDegree);

        // If the in-degree is ever zero, we need to return 
        // an empty array 

        int[] topologicalOrdering = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            int courseWithZeroIn = numCourses;

            for (Map.Entry<Integer, Integer> degree : courseInDegree.entrySet()) {
                if (degree.getValue() == 0) {
                    courseWithZeroIn = degree.getKey();

                    // Update in-degrees
                    for (int adjacentCourse : reqGraph.getOrDefault(courseWithZeroIn, new ArrayList<Integer>())) {
                        courseInDegree.put(adjacentCourse, courseInDegree.getOrDefault(adjacentCourse, 1) - 1);
                    }

                    courseInDegree.remove(degree.getKey());
                    break;
                }
            }

            if (courseWithZeroIn == numCourses) {
                return new int[0];
            } else {
                topologicalOrdering[i] = courseWithZeroIn; 
            }
        }

        return topologicalOrdering;
    }
}