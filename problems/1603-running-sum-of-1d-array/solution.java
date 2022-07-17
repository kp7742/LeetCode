class Solution {
    public int[] runningSum(int[] nums) {
        for(int n=1; n < nums.length; n++)
            nums[n] += nums[n-1];
        return nums;
    }
}