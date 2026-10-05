package arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        int idx =0;
        for (int num : nums) {
            if (num != val) {
                k++;
            }
        }
        int expectedNums[] = new int[k];
        for (int num : nums) {
            if (num != val) {
                num = expectedNums[idx];
                idx++;
            }
        }
        return k;
    }
}