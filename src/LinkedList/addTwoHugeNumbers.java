package LinkedList;


public class addTwoHugeNumbers {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    //
    ListNode<Integer> addTwoHugeNumbers(ListNode<Integer> a, ListNode<Integer> b) {
        a = reverse(a);
        b = reverse(b);
        ListNode<Integer> dummy = new ListNode<>(-1);
        ListNode<Integer> head = dummy;
        int carryOver = 0;
        while (a != null && b != null) {
            int sum = a.value + b.value + carryOver;
            if (sum >= 10000) {
                dummy.next = new ListNode<>(sum - 10000);
                carryOver = 1;
            } else {
                dummy.next = new ListNode<>(sum);
                carryOver = 0;
            }
            a = a.next;
            b = b.next;
            dummy = dummy.next;
        }
        while (a != null) {
            int sum = a.value + carryOver;
            if (sum >= 10000) {
                dummy.next = new ListNode<>(sum - 10000);
                carryOver = 1;
            } else {
                dummy.next = new ListNode<>(sum);
                carryOver = 0;
            }
            a = a.next;
            dummy = dummy.next;
        }

        while (b != null) {
            int sum = b.value + carryOver;
            if (sum >= 10000) {
                dummy.next = new ListNode<>(sum - 10000);
                carryOver = 1;
            } else {
                dummy.next = new ListNode<>(sum);
                carryOver = 0;
            }
            b = b.next;
            dummy = dummy.next;
        }

        if (carryOver != 0) {
            dummy.next = new ListNode<>(carryOver);
            dummy = dummy.next;
        }
        dummy.next = null;
        head = reverse(head.next);
        return head;
    }

    private ListNode<Integer> reverse(ListNode<Integer> head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode<Integer> trueNode = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return trueNode;
    }
}
