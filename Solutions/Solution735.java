class Solution735 {
  public int[] asteroidCollision(int[] asteroids) {

    // Edgecase
    if (asteroids == null || asteroids.length == 0) {
      return new int[0];
    }

    Stack<Integer> collisionStack = new Stack<>();

    for (int asteroid : asteroids) {
      if (collisionStack.isEmpty() || asteroid > 0) {
        // Asteroid heading rightwards or asteroids heading into the void leftwards
        collisionStack.push(asteroid);
      } else {
        // Asteroid heading leftwards into other asteroids
        while (true) {
          int collide = collisionStack.peek();
          if (collide < 0) {
            // Asteroids are heading in the same direction
            collisionStack.push(asteroid);
            break;
          } else if (asteroid * -1 < collide) {
            // Rightwards asteroid will destroy leftwards asteroid
            break;
          } else if (asteroid * -1 == collide) {
            // Asteroids will destroy each other
            collisionStack.pop();
            break;
          } else {
            // Leftwards asteroid will destroy rightwards asteroid
            collisionStack.pop();
            if (collisionStack.isEmpty()) {
              collisionStack.push(asteroid);
              break;
            }
          }
        }
      }
    }

    // Convert stack to array
    int[] finalState = new int[collisionStack.size()];
    for (int i = finalState.length - 1; i >= 0; i--) {
      finalState[i] = collisionStack.pop();
    }
    return finalState;
  }
}
