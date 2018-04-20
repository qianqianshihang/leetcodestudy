package medium;

/**
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumber_2 {
    public static void main(String[] args) {
        long start = System.nanoTime();
        ListNode listNode = new ListNode(2);
        ListNode listNode1 = new ListNode(4);
        listNode.next = listNode1;
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(5);
        ListNode listNode4 = new ListNode(6);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(4);
        listNode4.next = listNode5;

        long end = System.nanoTime();
        System.out.println("time = " + (end - start) + ",result=" + addTwoNumbers(listNode, listNode3).toString());
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        expectHandleAdd(l1, l2, result);
        return result;
    }

    public static void expectHandleAdd(ListNode l1, ListNode l2, ListNode reslt) {
        reslt.val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + reslt.val;
        if (reslt.val > 9) {
            int more = reslt.val / 10;
            reslt.val = reslt.val % 10;
            reslt.next = new ListNode(more);
        }

        if (l1 != null && l1.next != null || l2 != null && l2.next != null) {
            if (reslt.next == null) {
                reslt.next = new ListNode(0);
            }
            expectHandleAdd((l1 == null ? null : l1.next), (l2 == null ? null : l2.next), reslt.next);
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + (next == null ? "" : next.toString());
        }
    }

}
