package tree.heap;

import java.util.Arrays;

import java.util.PriorityQueue;

/*
    Problem: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 */
public class KthLargest {
    int k;

    PriorityQueue<Integer> priorityQueue;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        priorityQueue = new PriorityQueue<>(k + 1);
        Arrays.stream(nums).forEach(num -> {
            priorityQueue.add(num);

            if (priorityQueue.size() > k) priorityQueue.poll();
        });
    }

    public int add(int val) {

        priorityQueue.add(val);

        if(priorityQueue.size() > k)
            priorityQueue.poll();

        return priorityQueue.peek();
    }
}
