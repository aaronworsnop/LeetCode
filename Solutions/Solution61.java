class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        // First, find the size of the list
        int length = 0;
        ListNode lengthFinder = head;
        while (lengthFinder != null) {
            length++;
            lengthFinder = lengthFinder.next;
        }

        // Don't do extra work to rotate multiple times
        k %= length;

        if (k == 0) {
            return head;
        }

        // Find the heads and ends of the new start and stitch them
        // together.
        ListNode start = head;
        ListNode end = head;
        for (int i = 0; i < k; i++) {
            end = end.next;
        }

        while (end.next != null) {
            start = start.next;
            end = end.next;
        }

        ListNode newStart = start.next;
        start.next = null;
        end.next = head;

        return newStart;
    }
}