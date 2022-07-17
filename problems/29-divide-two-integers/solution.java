class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        int ans = 0;
        boolean dds = dividend > 0, dss = divisor > 0, signed = dds ^ dss;
        
        dividend = dds ? dividend : -dividend;
        divisor = dss ? divisor : -divisor;
        
        while (dividend - divisor >= 0) {
            int mod = 0;
            
            while(dividend - (divisor << mod << 1) >= 0)
                mod++;
            
            dividend -= divisor << mod;
            ans += 1 << mod;
        }
        
        return signed ? -ans : ans;
    }
}