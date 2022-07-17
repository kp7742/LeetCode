class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int numSum = (n*(n+1))/2; //Sum of n natural numbers
        while(n > 0){
            numSum -= nums[--n];
        }
        return numSum;
    }
}