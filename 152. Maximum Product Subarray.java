class Solution {
    public int maxProduct(int[] a) {
        
        int ans = Integer.MIN_VALUE;
 	     
 	     int currProd = 1;
 	     for(int i = 0; i < a.length; i++)
 	     {
 	         currProd *= a[i];
 	         ans = Math.max(ans, currProd);
 	         if(currProd == 0)
 	         {
 	             currProd = 1;
 	         }
 	     }
 	     
 	     currProd = 1;
 	     for(int i = a.length-1; i >= 0; i--)
 	     {
 	         currProd *= a[i];
 	         ans = Math.max(ans, currProd);
 	         if(currProd == 0)
 	         {
 	             currProd = 1;
 	         }
 	     }
        return ans;
        
    }
}
