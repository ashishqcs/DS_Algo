package linkedlist;

import model.Node;
import util.LinkedList;

/*
 * Problem Statement <a href="https://leetcode.com/problems/middle-of-the-linked-list/">here</href>
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class MiddleNode {

    public static void main(String[] args) {

        Node head = LinkedList.singlyLinkedList("1", "2", "3", "4");
        System.out.println(middleNode(head).data);
    }

    public static Node middleNode(Node head) {
        Node slowPtr = head;
        Node fastPtr = head;

        while(fastPtr != null && fastPtr.next !=null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }

        return slowPtr;
    }
}
