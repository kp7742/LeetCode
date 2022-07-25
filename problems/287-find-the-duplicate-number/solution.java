class Solution {
    public int findDuplicate(int[] nums) {
//         //Perform Cyclic Sort
//         for(int i = 0; i < nums.length;){
//             int num = nums[i];
            
//             //If already on right place move forward
//             if(num == i + 1){
//                 i++;
//                 continue;
//             }
            
//             int realIdx = nums[i] - 1;
//             //If number is already there
//             if(nums[realIdx] == num)
//                 return num;
            
//             //Swap the numbers
//             nums[i] = nums[realIdx];
//             nums[realIdx] = num;
//         }
//         return -1;
        //Perform Floyd's Cycle Detection
        int slow = 0, fast = 0;
		do{
			slow = nums[slow];
			fast = nums[nums[fast]];
        } while (slow != fast);
        
        //Check the cycle
        int i = 0;
        while(i != slow){
            i = nums[i];
            slow = nums[slow];
        }
        
        return slow;
    }
}