package leetcode.gsy.algorithms;

public class AddTwoNumbers_02 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode listNode = new ListNode(0);
        ListNode result = listNode;
        boolean overflow = false;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val;
            if (overflow) {
                sum += 1;
            }
            if (sum >= 10) {
                sum = sum - 10;
                overflow = true;
            } else {
                overflow = false;
            }
            l1 = l1.next;
            l2 = l2.next;
            listNode.next = new ListNode(sum);
            listNode = listNode.next;
        }
        while (l1 != null) {
            if (overflow) {
                l1.val += 1;
            }
            if (l1.val >= 10) {
                l1.val = l1.val - 10;
                overflow = true;
            } else {
                overflow = false;
            }
            listNode.next = new ListNode(l1.val);
            listNode = listNode.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            if (overflow) {
                l2.val += 1;
            }
            if (l2.val >= 10) {
                l2.val = l2.val - 10;
                overflow = true;
            } else {
                overflow = false;
            }
            listNode.next = new ListNode(l2.val);
            listNode = listNode.next;
            l2 = l2.next;
        }
        if (overflow) {
            listNode.next = new ListNode(1);
            listNode = listNode.next;
        }
        return result.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
