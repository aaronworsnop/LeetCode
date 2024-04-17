class Solution406 {
  public int[][] reconstructQueue(int[][] people) {
    // Edge and known cases
    if (people.length < 2) {
      return people;
    }

    // Sort the array by descending height, ascending k
    Arrays.sort(
        people,
        (a, b) -> {
          int x = Integer.compare(b[0], a[0]);
          if (x == 0) return Integer.compare(a[1], b[1]);
          else return x;
        });

    // Place people in the queue by their height group. Insert next height group
    // by their `k` value, as this doesn't affect the taller group. Repeat
    List<int[]> queue = new ArrayList<>();
    for (int[] person : people) {
      queue.add(person[1], person);
    }

    return queue.toArray(new int[people.length][2]);
  }
}
