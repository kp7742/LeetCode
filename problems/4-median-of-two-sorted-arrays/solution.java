class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1, B = nums2;
        int total = A.length + B.length;
        
        //Make sures A is smaller than B
        if(B.length < A.length){
            B = nums1;
            A = nums2;
        }
        
        //Dissecting Arrays
        int start = 0;
        int end = A.length;
        while(start <= end){
            int P1 = (start + end) / 2; //Half from A
            int P2 = (total + 1) / 2 - P1; //Another Half from B
            
            //Partition of A
            int AL = P1 > 0 ? A[P1 - 1] : Integer.MIN_VALUE;
            int AR = P1 < A.length ? A[P1] : Integer.MAX_VALUE;
            
            //Partiton of B
            int BL = P2 > 0 ? B[P2 - 1] : Integer.MIN_VALUE;
            int BR = P2 < B.length ? B[P2] : Integer.MAX_VALUE;
            
            if(AL <= BR && BL <= AR){
                //Odd
                if(total % 2 != 0)
                    return Math.max(AL, BL);
                //Odd
                return (Math.max(AL, BL) + Math.min(AR, BR)) / 2.0;
            } else if(AL > BR){
                end = P1 - 1;
            } else { //BL > AR
                start = P1 + 1;
            }
        }
        
        //Might not even reach here
        return 0;
    }
}