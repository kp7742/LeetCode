class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] result = new int[n];
        
        //Monotonic decreasing stack
        int top = -1;
        int[] stack = new int[n];
        
        for(int i = 0; i < n; i++){
            int temp = temperatures[i];
            
            //Pop till we got smaller number
            while(top >= 0 && temp > temperatures[stack[top]]){
                int stackT = stack[top--];
                result[stackT] = i - stackT;
            }
            
            //Push to the stack
            stack[++top] = i;
        }
        
        return result;
    }
}