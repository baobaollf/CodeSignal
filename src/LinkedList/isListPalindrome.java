package LinkedList;

import java.util.Objects;

public class isListPalindrome {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    boolean isListPalindrome(ListNode<Integer> l) {
        if (l == null || l.next == null) {
            return true;
        }
        ListNode<Integer> mid = findMid(l);
        ListNode<Integer> head2 = reverse(mid);

        while (head2 != null) {
            if (!l.value.equals(head2.value)) {
                return false;
            }
            l = l.next;
            head2 = head2.next;
        }
        return true;
    }

    private ListNode<Integer> reverse(ListNode<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode<Integer> trueHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return trueHead;
    }

    private ListNode<Integer> findMid(ListNode<Integer> l) {
        ListNode<Integer> slow = l;
        ListNode<Integer> fast = l;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        return slow;
    }

}
