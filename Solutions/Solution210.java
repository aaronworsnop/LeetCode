class Solution210 {
  public int[] findOrder(int numCourses, int[][] prerequisites) {
    // Find the topological ordering

    // First build adjacency list digraph representation
    // and the reverse
    Map<Integer, List<Integer>> reqGraph = new HashMap<>();
    int[] inDegree = new int[numCourses];

    // Build adjacency list and in-degree array
    for (int[] prerequisite : prerequisites) {
      int from = prerequisite[1];
      int to = prerequisite[0];

      reqGraph.computeIfAbsent(from, key -> new ArrayList<>()).add(to);
      inDegree[to]++;
    }

    Queue<Integer> zeroInDegreeQueue = new LinkedList<>();
    for (int course = 0; course < numCourses; course++) {
      if (inDegree[course] == 0) {
        zeroInDegreeQueue.offer(course);
      }
    }

    int[] topologicalOrdering = new int[numCourses];
    int index = 0;

    while (!zeroInDegreeQueue.isEmpty()) {
      int course = zeroInDegreeQueue.poll();
      topologicalOrdering[index++] = course;

      if (reqGraph.containsKey(course)) {
        for (int next : reqGraph.get(course)) {
          inDegree[next]--;
          if (inDegree[next] == 0) zeroInDegreeQueue.offer(next);
        }
      }
    }

    if (index == numCourses) {
      return topologicalOrdering;
    } else {
      return new int[0];
    }
  }
}
