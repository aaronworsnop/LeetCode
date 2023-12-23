/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution138 {
  public Node copyRandomList(Node head) {

    // Edgecases
    if (head == null) return null;

    Node current = head;
    Node deepHead = new Node(0);
    Node deepCurrent = deepHead;

    // Keep track of the deep relationship between two nodes
    Map<Node, Node> deepMap = new HashMap<>();

    // Creating a semi-deep copy. Completely new nodes, with correct
    // `val` pointers but shallow `random` pointers.
    while (current != null) {
      deepCurrent.val = current.val;
      deepCurrent.random = current.random;
      deepMap.put(current, deepCurrent);
      current = current.next;
      if (current != null) {
        deepCurrent.next = new Node(0);
        deepCurrent = deepCurrent.next;
      }
    }

    deepCurrent = deepHead;

    // Properly map the random pointers of the deep copy
    while (deepCurrent != null) {
      Node wrongRandom = deepCurrent.random;
      deepCurrent.random = deepMap.get(wrongRandom);
      deepCurrent = deepCurrent.next;
    }

    return deepHead;
  }
}
