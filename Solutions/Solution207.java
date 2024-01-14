class Solution207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    // Edgecases
    if (numCourses == 0 || prerequisites == null || prerequisites.length == 0) {
      return true;
    }

    Map<Integer, List<Integer>> reqGraph = new HashMap<>();
    for (int[] prerequisite : prerequisites) {
      List<Integer> adjacencies = reqGraph.getOrDefault(prerequisite[1], new ArrayList<>());
      adjacencies.add(prerequisite[0]);
      reqGraph.put(prerequisite[1], adjacencies);
    }

    // DFS
    Set<Integer> visited = new HashSet<>();

    for (int course = 0; course < numCourses; course++) {
      if (!dfs(course, reqGraph, visited)) return false;
    }

    return true;
  }

  public boolean dfs(int course, Map<Integer, List<Integer>> reqGraph, Set<Integer> visited) {
    if (visited.contains(course)) return false;
    if (reqGraph.get(course) == null || reqGraph.get(course).size() == 0) return true;

    visited.add(course);
    for (int req : reqGraph.get(course)) {
      if (!dfs(req, reqGraph, visited)) return false;
    }
    visited.remove(course);
    reqGraph.put(course, new ArrayList<>());

    return true;
  }
}
