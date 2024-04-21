class Solution {
  public double[] calcEquation(
      List<List<String>> equations, double[] values, List<List<String>> queries) {
    // Adjacency list with a map
    Map<String, List<Pair<String, Double>>> adjacencies = new HashMap<>();

    for (int index = 0; index < equations.size(); index++) {
      List<String> equation = equations.get(index);

      String numerator = equation.get(0);
      String denominator = equation.get(1);
      double value = values[index];

      List<Pair<String, Double>> numeratorAdjacencies =
          adjacencies.getOrDefault(numerator, new ArrayList<>());
      numeratorAdjacencies.add(new Pair<>(denominator, value));

      List<Pair<String, Double>> denominatorAdjacencies =
          adjacencies.getOrDefault(denominator, new ArrayList<>());
      denominatorAdjacencies.add(new Pair<>(numerator, 1 / value));

      adjacencies.put(numerator, numeratorAdjacencies);
      adjacencies.put(denominator, denominatorAdjacencies);
    }

    // For each query, find the path between the numerator and the denominator. If the
    // path doesn't exist, return -1.00
    int result = 0;
    double[] results = new double[queries.size()];

    queriesLoop:
    for (List<String> query : queries) {
      String numerator = query.get(0);
      String denominator = query.get(1);

      // If the numerator or the denominator is not in the list, invalid query
      boolean numeratorExists = false;
      boolean denominatorExists = false;
      for (Map.Entry<String, List<Pair<String, Double>>> node : adjacencies.entrySet()) {
        if (node.getKey().equals(numerator)) {
          numeratorExists = true;
        }

        if (node.getKey().equals(denominator)) {
          denominatorExists = true;
        }
      }

      if (!(numeratorExists && denominatorExists)) {
        results[result++] = -1.0;
        continue;
      }

      // BFS to find the denominator from the numerator
      Queue<Pair<String, Double>> queue = new LinkedList<>();
      Set<String> visited = new HashSet<>();
      queue.add(new Pair<String, Double>(numerator, 1.0));
      visited.add(numerator);

      bfsLoop:
      while (!queue.isEmpty()) {
        Pair<String, Double> currentNode = queue.poll();

        if (currentNode.getKey().equals(denominator)) {
          results[result++] = currentNode.getValue();
          continue queriesLoop;
        }

        List<Pair<String, Double>> currentAdjacencies = adjacencies.get(currentNode.getKey());

        for (Pair<String, Double> currentAdjancency : currentAdjacencies) {
          if (!visited.contains(currentAdjancency.getKey())) {
            queue.add(
                new Pair<>(
                    currentAdjancency.getKey(),
                    currentNode.getValue() * currentAdjancency.getValue()));
            visited.add(currentAdjancency.getKey());
          }
        }
      }

      results[result++] = -1.0;
    }

    return results;
  }
}
