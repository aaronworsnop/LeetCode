class Solution {
  public boolean canMeasureWater(int x, int y, int target) {

    // Edgecases
    if (target == 0) {
      // Nothing needs to hold water
      return true;
    } else if (target > x + y) {
      // Jugs can't hold enough water in total
      return false;
    } else if (x == y) {
      if (x * 2 == target || x == target) {
        return true;
      } else {
        // Jugs only have capacity combonations, neither of which meet
        // the target
        return false;
      }
    }

    Set<Integer> achievable = new HashSet<>();
    int[] operations = new int[] {x, y, -x, -y};
    return jugDfs(0, target, operations, achievable);
  }

  private boolean jugDfs(int capacity, int target, int[] operations, Set<Integer> achievable) {
    if (capacity == target) {
      return true;
    }

    if (achievable.contains(capacity) || capacity < 0 || capacity > operations[0] + operations[1]) {
      return false;
    }

    achievable.add(capacity);

    return (jugDfs(capacity + operations[0], target, operations, achievable)
        || jugDfs(capacity + operations[1], target, operations, achievable)
        || jugDfs(capacity + operations[2], target, operations, achievable)
        || jugDfs(capacity + operations[3], target, operations, achievable));
  }
}
