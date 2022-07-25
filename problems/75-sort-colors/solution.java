class Solution {
    public void sortColors(int[] nums) {
        int r = 0, w = 0, b = nums.length - 1;
        while(w <= b){
            int num = nums[w];
            
            if(num == 2){ //When we get Blue, move it to right side
                nums[w] = nums[b];
                nums[b] = num;
                b--;
            } else if(num == 0){ //When get Red, move it to left side
                nums[w] = nums[r];
                nums[r] = num;
                r++;
                w++;
            } else { //On White, Move to next color
                w++;
            }
        }
    }
}