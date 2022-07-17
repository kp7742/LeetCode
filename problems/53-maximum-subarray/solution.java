class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for(int n = 0, sum = 0; n < nums.length; n++){
            sum += nums[n];
            maxSum = Math.max(sum, maxSum);
            if(sum < 0)
                sum = 0;
        }
        return maxSum;
    }
}