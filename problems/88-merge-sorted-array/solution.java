class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        
        int l = 0; //Pointer For nums1
        int r = 0; //Pointer for nums2
        
        //Copy nums1 to temp
        int[] temp = new int[m];
        for(;l < m;l++)
            temp[l] = nums1[l];
        
        l = 0; //Pointer reset
        
        //Merge in sorted order
        for(int i=0; i < (m+n); i++){
            if(r >= n || (l < m && temp[l] <= nums2[r])){
                nums1[i] = temp[l++];
            } else if(l >= m || (r < n && temp[l] > nums2[r])) {
                nums1[i] = nums2[r++];
            }
        }
    }
}