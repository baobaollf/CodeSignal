package LinkedList;

public class rearrangeLastN {

    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }
    ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
        int[] length = new int[1];
        ListNode<Integer> tail = findTail(l, length);
        if (n == 0 || l == null || n == length[0] + 1) {
            return l;
        }
        ListNode<Integer> secondHead = findNode(l, length[0] - n + 1);

        tail.next = l;
        return secondHead;
    }

    private ListNode<Integer> findTail(ListNode<Integer> l, int[] length) {
        while (l != null && l.next != null) {
            length[0]++;
            l = l.next;
        }
        return l;
    }

    private ListNode<Integer> findNode(ListNode<Integer> l, int n) {
        ListNode<Integer> secondHead = l;
        ListNode<Integer> previous = null;

        for (int i = 0; i < n; i++) {
            previous = secondHead;
            secondHead = secondHead.next;
        }

        if (previous != null) {
            previous.next = null;
        }
        return secondHead;
    }

}
