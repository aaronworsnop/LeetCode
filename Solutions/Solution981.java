class TimeMap {
  Map<String, List<Pair<Integer, String>>> store;

  public TimeMap() {
    store = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    if (store.containsKey(key)) {
      store.get(key).add(new Pair<Integer, String>(timestamp, value));
    } else {
      List<Pair<Integer, String>> valuePair = new ArrayList<>();
      Pair<Integer, String> values = new Pair<>(timestamp, value);
      valuePair.add(values);
      store.put(key, valuePair);
    }
  }

  public String get(String key, int timestamp) {
    // binary search for the timestamp. If we don't find it then we just return the left of it.
    // If that also doesn't exist we return "".

    if (!store.containsKey(key)) return "";

    List<Pair<Integer, String>> list = store.get(key);

    int left = 0;
    int right = list.size() - 1;

    while (left <= right) {
      int mid = left + (right - left) / 2;
      int midTimestamp = list.get(mid).getKey();
      if (midTimestamp == timestamp) return list.get(mid).getValue();
      if (midTimestamp < timestamp) left = mid + 1;
      else right = mid - 1;
    }

    if (right >= 0) return list.get(right).getValue();
    else return "";
  }
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp); String param_2 = obj.get(key,timestamp);
 */
