package LinkedList;


public class removeKFromList {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    //
    ListNode<Integer> removeKFromList(ListNode<Integer> l, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (l != null) {
            if (l.value != k) {
                dummy.next = l;
                dummy = dummy.next;

            }
            l = l.next;
        }
        dummy.next = null;
        return head.next;
    }

}
