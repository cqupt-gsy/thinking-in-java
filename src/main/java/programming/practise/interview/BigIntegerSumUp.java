package programming.practise.interview;

public class BigIntegerSumUp {
    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        boolean hasNext() {
            return next != null;
        }
    }

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

    public static void main(String args[]) {
        BigIntegerSumUp bigIntegerSumUp = new BigIntegerSumUp();
        ListNode firstNumber = new ListNode(1); //mock initial big numbers, the root node of the first big number
        ListNode secondNumber = new ListNode(2); //mock initial big numbers, the root node of the second big number
        ListNode result = bigIntegerSumUp.addTwoNumbers(firstNumber, secondNumber); //get the root of the two sum number
        while (result.hasNext()) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}
