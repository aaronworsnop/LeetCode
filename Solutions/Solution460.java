class LFUCache {
    private int capacity;
    private int leastFreq;

    // freq : Set of keys (This also gives number of keys at a freq)
    private Map<Integer, LinkedHashSet<Integer>> freqKeysMap;
    
    // key : value
    private Map<Integer, Integer> keyValueMap;

    // key : freq
    private Map<Integer, Integer> keyFreqMap;


    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.leastFreq = 0;
        this.freqKeysMap = new HashMap<>();
        this.keyValueMap = new HashMap<>();
        this.keyFreqMap = new HashMap<>();
    }
    
    public int get(int key) {
        // Retrieve and increment frequency
        if (keyValueMap.containsKey(key)) {
            increaseFrequency(key);
            return keyValueMap.get(key);
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyValueMap.containsKey(key)) {
            // Update value and increase frequency
            increaseFrequency(key);

            // Remember to update value
            keyValueMap.put(key, value);
            return;
        } 
        
        if (keyValueMap.size() >= capacity) {
            Set<Integer> removeSet = freqKeysMap.get(leastFreq);
            int removeKey = removeSet.iterator().next(); // Remove one key (LFU + LRU)
            removeSet.remove(removeKey);
            if (removeSet.isEmpty()) {
                freqKeysMap.remove(leastFreq);
            }
            keyValueMap.remove(removeKey);
            keyFreqMap.remove(removeKey);
        }

        // Insert new key with frequency 1
        keyValueMap.put(key, value);
        keyFreqMap.put(key, 1);
        freqKeysMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(key);
        leastFreq = 1;
    }

    private void increaseFrequency(int key) {
        int oldFrequency = keyFreqMap.get(key);
        int newFrequency = oldFrequency + 1;
        // Update the frequency
        keyFreqMap.put(key, newFrequency);
        
        // Remove from old frequency tier
        Set<Integer> keys = freqKeysMap.get(oldFrequency);
        keys.remove(key);
        if (keys.isEmpty()) {
            freqKeysMap.remove(oldFrequency);
            if (oldFrequency == leastFreq) {
                leastFreq++;
            }
        }
        
        // Add to new frequency tier 
        LinkedHashSet<Integer> newKeys = freqKeysMap.getOrDefault(newFrequency, new LinkedHashSet<>());
        newKeys.add(key);
        freqKeysMap.put(newFrequency, newKeys);
    }
}
