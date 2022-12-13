package linkedlist;

import java.util.List;

public class LinkedList {

    public static Node singlyLinkedList (List<String> dataList){
        Node head = null;
        Node prev = null;
        for (String data : dataList) {
            Node node = new Node(null, data, null);
            if(prev != null) prev.next = node;
            prev = node;
            if(head == null) head = node;
        }
        return head;
    }
}
