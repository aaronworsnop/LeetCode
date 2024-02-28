class RandomizedSet {
  Map<Integer, Integer> map;
  List<Integer> existingElementIndices;

  public RandomizedSet() {
    this.map = new HashMap<>();
    this.existingElementIndices = new ArrayList<>();
  }

  public boolean insert(int val) {
    if (map.containsKey(val)) {
      return false;
    } else {
      map.put(val, existingElementIndices.size());
      existingElementIndices.add(val);
      return true;
    }
  }

  public boolean remove(int val) {
    if (!map.containsKey(val)) {
      return false;
    } else {
      int index = map.get(val);
      int lastVal = existingElementIndices.get(existingElementIndices.size() - 1);

      // Update the index of the last element in the map
      map.put(lastVal, index);

      // Swap the values at index and size-1, then remove the last element
      existingElementIndices.set(index, lastVal);
      existingElementIndices.remove(existingElementIndices.size() - 1);

      map.remove(val);
      return true;
    }
  }

  public int getRandom() {
    Random rand = new Random();
    return existingElementIndices.get(rand.nextInt(existingElementIndices.size()));
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such: RandomizedSet obj = new
 * RandomizedSet(); boolean param_1 = obj.insert(val); boolean param_2 = obj.remove(val); int
 * param_3 = obj.getRandom();
 */
