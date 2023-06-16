package Array;

/**
 * Problem: <a href="https://leetcode.com/problems/majority-element/">Majority Element</a>
 * <p>Solution using <a href="https://www.topcoder.com/thrive/articles/boyer-moore-majority-vote-algorithm">
 *     BOYER MOORE MAJORITY VOTE ALGORITHM </a>  </p>
 *  <p>Time Complexity - best O(n) </p>
 *  <p>Space Complexity - best O(1)</p>
 *
 *  It can also be solved using map in O(n) time and O(n) space
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = new int[]{5,6,6};

        System.out.println(majorityElement(arr));
    }

    public static int majorityElement(int[] nums) {
        int num = 0;
        int count = 0;

        for (int j : nums) {
            if (count == 0) {
                num = j;
            }
            count += j == num ? 1 : -1;
        }

        count = 0;
        for(int x: nums){
            if(x == num)
                count++;
        }

        if(count > nums.length/2) return num;

        return -1;
    }
}
