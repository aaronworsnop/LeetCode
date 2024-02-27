class RandomizedSet {
  List<Integer>[] table;
  int capacity;
  List<Integer> existingElementIndices;

  public RandomizedSet() {
    // Create a table with size `capacity`
    this.capacity = 2 * (int) Math.pow(10, 5);
    this.table = new List[capacity];
    this.existingElementIndices = new ArrayList<>();

    this.table = new List[capacity];
    for (int i = 0; i < capacity; i++) {
      table[i] = new LinkedList<>();
    }
  }

  public boolean insert(int val) {
    int hash = hash(val);
    List<Integer> elementList = table[hash];

    if (elementList.contains(val)) {
      return false;
    } else {
      elementList.add(val);
      existingElementIndices.add(hash);
      return true;
    }
  }

  public boolean remove(int val) {
    int hash = hash(val);
    List<Integer> elementList = table[hash];

    for (int index = 0; index < elementList.size(); index++) {
      if (elementList.get(index) == val) {
        elementList.remove(index);

        // This is not O(1)
        if (elementList.size() == 0) {
          existingElementIndices.remove(existingElementIndices.indexOf(hash));
        }

        return true;
      }
    }

    return false;
  }

  public int getRandom() {
    Random rand = new Random();
    int randomIndex = rand.nextInt(existingElementIndices.size());
    List<Integer> elementList = table[existingElementIndices.get(randomIndex)];
    int randomCollisionIndex = rand.nextInt(elementList.size());
    return elementList.get(randomCollisionIndex);
  }

  private int hash(int val) {
    // capacity is the upper bound
    val ^= (val << 13);
    val ^= (val >>> 17);
    val ^= (val << 5);
    return val % capacity;
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new
 * RandomizedSet(); boolean param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int
 * param_3 = obj.getRandom();
 */
