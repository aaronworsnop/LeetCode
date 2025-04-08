public class AllOne {
    private Node high;
    private Node low;
    private Map<String, Node> stringNodeMap;

    public AllOne() {
        stringNodeMap = new HashMap<>();
        high = new Node();
        low = new Node();
        low.next = high;
        high.prev = low;
    }
    
    public void inc(String key) {
        if (stringNodeMap.get(key) == null) {
            // This string doesn't exist yet
            Node next = low.next;

            if (next.count != 1) {
                // There are no strings with count 1
                Node minNode = new Node(1);
                low.next = minNode;
                minNode.prev = low;
                minNode.next = next;
                next.prev = minNode;
                minNode.strings.add(key);
                stringNodeMap.put(key, minNode);
            } else {
                next.strings.add(key);
                stringNodeMap.put(key, next);
            }
        } else {
            Node currentCountNode = stringNodeMap.get(key);
            stringNodeMap.remove(key);
            int currentCount = currentCountNode.count;
            currentCountNode.strings.remove(key);

            if (currentCountNode.strings.isEmpty()) {
                // All strings with this count are gone, remove the node
                currentCountNode.prev.next = currentCountNode.next;
                currentCountNode.next.prev = currentCountNode.prev;
                currentCountNode = currentCountNode.prev;
            }

            Node nextCountNode;
            if (currentCountNode.next.count == currentCount + 1) {
                nextCountNode = currentCountNode.next;
            } else {
                Node next = currentCountNode.next;
                nextCountNode = new Node(currentCount + 1, currentCountNode, next);
                currentCountNode.next = nextCountNode;
                next.prev = nextCountNode;
            }

            nextCountNode.strings.add(key);
            stringNodeMap.put(key, nextCountNode);
        }
    }
    
    public void dec(String key) {
        Node currentCountNode = stringNodeMap.get(key);
        stringNodeMap.remove(key);
        int currentCount = currentCountNode.count;
        currentCountNode.strings.remove(key);

        if (currentCountNode.strings.isEmpty()) {
            currentCountNode.prev.next = currentCountNode.next;
            currentCountNode.next.prev = currentCountNode.prev;
            currentCountNode = currentCountNode.next;
        }

        if (currentCount - 1 == 0) {
            return;
        }

        Node nextCountNode;
        if (currentCountNode.prev.count == currentCount - 1) {
            nextCountNode = currentCountNode.prev;
        } else {
            Node prev = currentCountNode.prev;
            nextCountNode = new Node(currentCount - 1, prev, currentCountNode);
            currentCountNode.prev = nextCountNode;
            prev.next = nextCountNode;
        }

        nextCountNode.strings.add(key);
        stringNodeMap.put(key, nextCountNode);
    }
    
    public String getMaxKey() {
        Iterator iterator = high.prev.strings.iterator();
        return iterator != null && iterator.hasNext() ? (String) iterator.next() : "";
    }
    
    public String getMinKey() {
        Iterator iterator = low.next.strings.iterator();
        return iterator != null && iterator.hasNext() ? (String) iterator.next() : "";
    }

    class Node {
        int count = -1;
        Node prev;
        Node next;
        Set<String> strings = new HashSet<>();

        Node() {}

        Node(int count) {
            this.count = count;
        }

        Node(int count, Node prev, Node next) {
            this.count = count;
            this.prev = prev;
            this.next = next;
        }
    }
}
