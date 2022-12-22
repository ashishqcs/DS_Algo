package model;

public class Node {
    public Node prev;
    public String data;
    public Node next;

    public Node(Node prev, String data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

}
