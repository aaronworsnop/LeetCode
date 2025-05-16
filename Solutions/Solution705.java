class MyHashSet {
    private List<Integer>[] set;
    private int size;
    private int numElements;

    public MyHashSet() {
        this.size = 2;
        this.numElements = 0;
        this.set = (ArrayList<Integer>[]) new ArrayList[2];
    }
    
    public void add(int key) {
        if (contains(key)) return;

        if ((double) numElements / (double) size >= 0.75) {
            resizeSet(true);
        }
        
        int index = Integer.hashCode(key);
        index %= size;
        List<Integer> mapping = set[index];
        if (mapping == null) mapping = new ArrayList<>();
        mapping.add(key);
        set[index] = mapping;
        numElements++;
    }
    
    public void remove(int key) {
        if (!contains(key)) return;

        int index = Integer.hashCode(key);
        index %= size;
        List<Integer> mapping = set[index];
        for (int i = 0; i < mapping.size(); i++) {
            if (mapping.get(i) == key) mapping.remove(i);
        }
        numElements--;

        if ((double) numElements / (double) size < 0.75) {
            resizeSet(false);
        }
    }
    
    public boolean contains(int key) {
        int index = Integer.hashCode(key);
        index %= size;
        
        List<Integer> mapping = set[index];
        if (mapping == null) return false;
        for (int value : mapping) {
            if (value == key) return true;
        }

        return false;
    }

    private void resizeSet(boolean increase) {
        if (!increase && size == 2) return;

        if (increase == true) {
            size *= 2;
        } else {
            size /= 2;
        }

        List<Integer>[] newSet = (ArrayList<Integer>[]) new ArrayList[size];
        for (int i = 0; i < set.length; i++) {
            List<Integer> mapping = set[i];
            if (mapping == null) continue;
            for (int key : mapping) {
                int newIndex = Integer.hashCode(key);
                newIndex %= size;
                
                List<Integer> newMapping = newSet[newIndex];
                if (newMapping == null) newMapping = new ArrayList<>();
                newMapping.add(key);
                newSet[newIndex] = newMapping;
            }
        }

        set = newSet;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */