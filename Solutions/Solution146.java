class LRUCache {
  // This data structure has a specific capacity, and will
  // be filled or accessed. When we want to add something to
  // this data structure, but it is at capacity, we will
  // need to replace the least recently used item (lowest)
  // number that we assigned.

  // When an item is accessed, it should become the highest/
  // most recently used item.

  // We could have a LinkedList that starts

  private int capacity;
  private int[][] cache;
  private int highestPriority;

  public LRUCache(int capacity) {
    this.highestPriority = 0;
    this.capacity = capacity;
    this.fill = 0;
    // Depth 0: key
    // Depth 1: value
    // Depth 2: priority
    this.cache = new int[capacity][3];
    for (int i = 0; i < capacity; i++) {
      for (int j = 0; j < 3; j++) {
        cache[i][j] = -1;
      }
    }
  }

  public int get(int key) {
    highestPriority++;
    int i = 0;
    while (cache[i][0] != key) {
      i++;
      if (i == capacity) {
        return -1;
      }
    }
    cache[i][2] = highestPriority;
    return cache[i][1];
  }

  public void put(int key, int value) {
    highestPriority++;

    // Check if we're replacing a key
    for (int i = 0; i < capacity; i++) {
      if (cache[i][0] == key) {
        cache[i][1] = value;
        cache[i][2] = highestPriority;
        return;
      }
    }

    if (highestPriority <= capacity) {
      int nextSpot = highestPriority - 1;
      cache[nextSpot][0] = key;
      cache[nextSpot][1] = value;
      cache[nextSpot][2] = highestPriority;
    } else {
      int least = cache[0][2];
      int leastPosition = 0;
      for (int i = 0; i < capacity; i++) {
        if (cache[i][2] < least) {
          least = cache[i][2];
          leastPosition = i;
        }
      }

      cache[leastPosition][0] = key;
      cache[leastPosition][1] = value;
      cache[leastPosition][2] = highestPriority;
    }
  }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj = new
 * LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
