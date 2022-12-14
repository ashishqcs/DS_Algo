package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * Problem Statement <a href="https://leetcode.com/problems/two-sum/">here</href>
 * Time Complexity - best O(n)
 * Space Complexity - best O(1)
 * */
public class TwoSum {

    // Map with difference approach - O(n) time and O(1) space
    public int[] twoSum(int[] nums, int target) {
        int[] solution = new int[2];

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i=0; i<nums.length; i++){
            int diff = target - nums[i];
            if(numMap.containsKey(diff)){
                solution[0] = numMap.get(diff);
                solution[1] = i;
            }
            numMap.putIfAbsent(nums[i], i);
        }

        return solution;
    }

    // Sorting with 2 pointers approach - O(n*logn) time
    public boolean twoSum(int[] nums, int target, int dummy) {
        int start = 0;
        int end = nums.length - 1;
        int[] solution = new int[2];
        Arrays.sort(nums); // 2 3 4
        while (start < end){
            if(nums[start]+nums[end] == target){
                solution[0] = start;
                solution[1] = end;
                return true;
            }

            if (nums[start] + nums[end] > target) end--;
            else start++;
        }

        return false;
    }
}
