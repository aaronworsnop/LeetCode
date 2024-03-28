class Solution24 {
  public ListNode swapPairs(ListNode head) {
    // Edgecases
    if (head == null || head.next == null) {
      return head;
    }

    ListNode first = head;
    ListNode second = head.next;
    ListNode nextPair;

    // _
    // 2, 1, 3, 4, 5
    // *  ^  -
    // first: ^, second: *, nextPair: -, head: _

    // Set head to final head, after swaps
    head = head.next;

    // Swap until we have no more pairs, or reach the end of the list
    while (first != null && second != null) {
      // Swap
      nextPair = second.next;

      first.next = nextPair;
      second.next = first;
      if (nextPair != null && nextPair.next != null) {
        first.next = nextPair.next;
      }

      // Setup for next swap
      first = nextPair;
      if (first != null) {
        second = first.next;
      }
    }

    return head;
  }
}
