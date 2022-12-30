package Array;

import java.util.Scanner;

public class CircularQueue {

    private final int[] queue;
    private int front = -1;
    private int rear = -1;

    public CircularQueue(int size) {
        queue = new int[size];
    }

    public CircularQueue() {
        queue = new int[4];
    }

    public void enQueue(int i) {
        if (front == (rear + 1) % queue.length) {
            System.out.println("Queue is full.");
            return;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = i;

        if (front == -1) front = 0;
    }

    public void deQueue() {
        if (emptyQueue()) return;
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % queue.length;
        }
    }

    public void display() {
        if (emptyQueue()) return;
        int it = front;
        while (true) {
            System.out.println(queue[it]);
            if(it == rear) break;
            it = (it + 1) % queue.length;
        }
    }

    public void front() {
        if (emptyQueue()) return;
        System.out.println(queue[front]);
    }

    private boolean emptyQueue() {
        if (front == -1 && rear == -1) {
            System.out.println("Queue is empty.");
            return true;
        }

        return false;
    }
}

class Test {
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue();
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("""
                    1-> enqueue
                    2-> dequeue
                    3-> front
                    4-> display
                    0-> exit
                    """);
            input = sc.nextInt();
            int num;
            switch (input){
                case 1 -> {System.out.println("Enter number"); num = sc.nextInt(); cq.enQueue(num);}
                case 2 -> cq.deQueue();
                case 3 -> cq.front();
                case 4 -> cq.display();
                default -> System.out.println("Invalid input.");
            }
        }
        while (input != 0);
    }
}
