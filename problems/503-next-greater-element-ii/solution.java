class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        
        //Result array
        int[] result = new int[len];
        Arrays.fill(result, -1);
        
        //Generate monotonically decreasing stack of indices
        int top = -1;
        int[] stack = new int[len];
        
        for (int i = 0; i < len * 2; i++) {
            int num = nums[i % len];
            
            while(top >= 0 && nums[stack[top]] < num){
                result[stack[top--]] = num;
            }
            
            if(i < len)
                stack[++top] = i;
        }
        
        return result;
    }
}