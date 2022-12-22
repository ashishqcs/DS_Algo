package linkedlist;

import model.Node;

import static util.LinkedList.singlyLinkedList;

/*
 * Problem Statement <a href="https://leetcode.com/problems/palindrome-linked-list/">here</href>
 * Time Complexity - O(n)
 * Space Complexity - O(1)
 */
public class PalindromeLinkedList {

    public static void main(String[] args) {
        Node head = singlyLinkedList("1", "2", "2", "1");
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(Node head) {
        if (head == null) return false;

        StringBuilder stringBuilder = new StringBuilder();
        Node node = head;
        while (node != null) {
            stringBuilder.append(node.data);
            node = node.next;
        }
        String original = stringBuilder.toString();
        String reversed = stringBuilder.reverse().toString();

        return original.equals(reversed);
    }
}
