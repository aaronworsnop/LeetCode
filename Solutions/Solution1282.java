class Solution1282 {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    Map<Integer, List<Integer>> groupMap = new HashMap<>();
    List<List<Integer>> groups = new ArrayList<>();

    for (int individual = 0; individual < groupSizes.length; individual++) {
      List<Integer> group = groupMap.getOrDefault(groupSizes[individual], new ArrayList<Integer>());
      group.add(individual);
      groupMap.put(groupSizes[individual], group);

      if (group.size() == groupSizes[individual]) {
        groups.add(group);
        groupMap.remove(groupSizes[individual]);
      }
    }

    return groups;
  }
}
