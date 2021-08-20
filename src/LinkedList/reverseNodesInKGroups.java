package LinkedList;


import java.util.*;

public class reverseNodesInKGroups {
    // Singly-linked lists are already defined with this interface:
    class ListNode<T> {
        ListNode(T x) {
            value = x;
        }

        T value;
        ListNode<T> next;
    }

    ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> head, int k) {
        ListNode<Integer> dummy = new ListNode<Integer>(-1);
        dummy.next = head;
        ListNode<Integer> begin = dummy;
        int size = 0;
        while (head != null) {
            size++;
            if (size % k == 0) {
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
//            ListNode<Integer> tempHead = new ListNode<Integer>(-1);
//            ListNode<Integer> tempDummy = tempHead;
//            while (head != null && size < k) {
//                tempHead.next = head;
//                tempHead = tempHead.next;
//                head = head.next;
//                size++;
//            }
//
//            if (size == k) {
//                tempHead = reverse(tempDummy.next, tempHead);
//                dummy.next = tempHead;
//
//
//            } else {
//                dummy.next = tempHead;
//
//            }
//            while (dummy != null && dummy.next != null) {
//                dummy = dummy.next;
//            }
        }
        return dummy.next;
    }

    private ListNode<Integer> reverse(ListNode<Integer> begin, ListNode<Integer> end) {
        ListNode<Integer> curr = begin.next;
        ListNode<Integer> next, first;
        ListNode<Integer> prev = begin;
        first = curr;
        while (curr!=end){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }

}
