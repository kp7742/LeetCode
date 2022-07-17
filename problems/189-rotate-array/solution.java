class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        
        k %= n; //If k > length of array
        if(k == 0)
            return; // No need of modifcation
        
        reverse(nums, 0, n - 1); //Reverse whole array
        reverse(nums, 0, k - 1); //Reverse first part
        reverse(nums, k, n - 1); //Reverse second part
    }
    
    public void reverse(int nums[], int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start++] = nums[end];
            nums[end--] = temp;
        }
    }
}