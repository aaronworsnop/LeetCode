class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // Edge and known cases
        if (head == null || head.next == null || k < 2) {
            // List remains the same
            return head;
        }

        ListNode dummyHead = new ListNode(0, head);
        ListNode previousGroup = dummyHead;

        while (true) {
            ListNode groupEnd = getKthFrom(previousGroup, k);
            if (groupEnd == null) {
                // There are no more valid groups to reverse
                break;
            }

            ListNode nextGroup = groupEnd.next;

            // Reverse the group
            ListNode current = previousGroup.next;
            ListNode previous = groupEnd.next;
            ListNode next = current.next;

            while (current != nextGroup) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // Link up the list again
            next = previousGroup.next;
            previousGroup.next = groupEnd;
            previousGroup = next;
        }

        return dummyHead.next;
    }

    private ListNode getKthFrom(ListNode node, int k) {
        while (node != null && k-- > 0) {
            node = node.next;
        }

        return node;
    }
}