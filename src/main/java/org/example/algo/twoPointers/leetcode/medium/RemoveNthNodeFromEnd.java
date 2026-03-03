package org.example.algo.twoPointers.leetcode.medium;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/?envType=problem-list-v2&envId=two-pointers
public class RemoveNthNodeFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Part 1 ---> calculate the length of the list
        ListNode countNode = head;
        int length = 0;
        while (countNode != null) { // loop until the countNode is null
            countNode = countNode.next;
            length++;
        }

        // Part 2 -> remove element
        int target = length - n; // calculate the index to remove from end
        // point the node at head
        ListNode prevNode = head;
        ListNode frontNode = head;
        int count = 0;
        // loop until the target is found
        while (count < target && frontNode != null) {
            prevNode = frontNode;
            frontNode = frontNode.next;
            count++;
        }

        // if target is last
        if (target == 0) {
            head = head.next;
        } else if (frontNode != null) {
            prevNode.next = frontNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1, null);
        removeNthFromEnd(listNode, 1);
    }
}
