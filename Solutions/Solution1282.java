class Solution1282 {
  public List<List<Integer>> groupThePeople(int[] groupSizes) {
    List<List<Integer>> groups = new ArrayList<>();
    int numberOfGroups = 0;

    individualsLoop:
    for (int individual = 0; individual < groupSizes.length; individual++) {
      // Find the group that this individual fits into
      groupSizes[numberOfGroups] = groupSizes[individual];
      for (int group = 0; group < numberOfGroups; group++) {
        if (groupSizes[individual] == groupSizes[group]
            && groups.get(group).size() < groupSizes[group]) {
          groups.get(group).add(individual);
          continue individualsLoop;
        }
      }

      // No group for this individual to fit into, create a new group
      groups.add(new ArrayList<Integer>(Arrays.asList(individual)));
      numberOfGroups++;
    }

    System.out.println(groups);

    return groups;
  }
}
