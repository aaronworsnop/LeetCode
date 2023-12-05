class Solution853 {
  public int carFleet(int target, int[] position, int[] speed) {
    int fleets = 0;
    int length = position.length;

    // Edgcases
    if (length == 1) return 1;
    if (length == 0) return 0;

    // Create a better representation of the lane that we can work with
    // and find out when each car reaches the target
    double[][] cars = new double[length][2];
    for (int i = 0; i < length; i++) {
      cars[i] = new double[] {position[i], (double) (target - position[i]) / speed[i]};
    }

    // Sort by furthest cars to closest cars (From the target)
    Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
    double current = 0;
    for (int i = length - 1; i >= 0; i--) {
      if (cars[i][1] > current) {
        current = cars[i][1];
        fleets++;
      }
    }

    return fleets;
  }
}
