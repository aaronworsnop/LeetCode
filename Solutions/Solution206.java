class Solution206 {
    public ListNode reverseList(ListNode head) {
        // Edgecases
        if (head == null) {
            return null;
        } else if (head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        return previous;
    }
}