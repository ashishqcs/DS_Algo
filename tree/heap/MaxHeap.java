package tree.heap;

import java.util.Scanner;

public class MaxHeap {

    private final int[] heap;
    private int size;

    public int size(){
        return size;
    }

    public MaxHeap() {
        heap = new int[16];
    }

    public void insert(int data) {
        if(size >= heap.length){
            System.out.println("Heap is full");
            return;
        }

        size++;
        heap[size-1] = data;
        heapify(size-1);
    }

    private void heapify(int index){
        if(index <= 0) return;

        int parentIndex = (index % 2) == 0 ? (index - 2) / 2 : (index - 1) / 2;

        if (heap[parentIndex] < heap[index]){
            swap(parentIndex, index);
            heapify(parentIndex);
        }
    }

    public void delete(){
        if (size < 1) System.out.println("Heap is empty");

        size--;
        heap[0] = heap[size];

        maxHeapify(0);
    }

    public void display(){
        if (size < 1) {
            System.out.println("Heap is empty");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(heap[i]);
        }
    }

    private void maxHeapify(int index){

        int lChild = 2*index + 1;
        int rChild = 2*index + 1;
        int max = index;
        if(lChild < size && heap[lChild] > heap[index]){
            max = lChild;
        }
        if(rChild < size && heap[rChild] > heap[max]) {
            max = rChild;
        }
        if(max != index){
            swap(index, max);
            maxHeapify(max);
        }

    }

    private void swap(int index1, int index2){
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private void getMax(){
        if (size < 1){
            System.out.println("Heap is empty");
            return;
        }
        System.out.println(heap[0]);
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        Scanner sc = new Scanner(System.in);
        int input;
        do {
            System.out.println("""
                    1-> insert
                    2-> delete
                    3-> show max
                    4-> display all
                    0-> exit
                    """);
            input = sc.nextInt();
            int num;
            switch (input){
                case 1 -> {System.out.println("Enter number"); num = sc.nextInt(); maxHeap.insert(num);}
                case 2 -> maxHeap.delete();
                case 3 -> maxHeap.getMax();
                case 4 -> maxHeap.display();
                default -> System.out.println("Invalid input.");
            }
        }
        while (input != 0);
    }
}
