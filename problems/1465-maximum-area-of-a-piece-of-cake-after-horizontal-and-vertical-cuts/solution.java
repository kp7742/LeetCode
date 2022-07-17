class Solution {
    public int max(int a, int b){
        return Math.max(a, b);
    }
    
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        //Sort both the arrays
        Arrays.sort(verticalCuts);
        Arrays.sort(horizontalCuts);
        
        //Find maximum vertical side
        int vMax = verticalCuts[0];
        int vlength = verticalCuts.length;
        for(int i = 0; i < vlength - 1; i++){
            vMax = max(vMax, verticalCuts[i+1] - verticalCuts[i]);
        }
        vMax = max(vMax, w - verticalCuts[vlength - 1]);
        
        //Find maximum horizontal side
        int hMax = horizontalCuts[0];
        int hlength = horizontalCuts.length;
        for(int i = 0; i < hlength - 1; i++){
            hMax = max(hMax, horizontalCuts[i+1] - horizontalCuts[i]);
        }
        hMax = max(hMax, h - horizontalCuts[hlength - 1]);
        
        //Mod the result
        return (int) (((long)hMax * (long)vMax) % (long)1000000007);
    }
}