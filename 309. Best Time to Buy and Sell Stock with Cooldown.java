class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length == 0 || prices.length == 1)
            return 0;
        
        int buyP = -prices[0];
        int sellP = 0;
        int coolP = 0;
        
        for(int i = 1; i < prices.length; i++)
        {
            int nSellP, nBuyP, nCoolP;
            
            /* buying*/
            
            if(coolP - prices[i] > buyP)
            {
               nBuyP =  coolP - prices[i];
            }
            else
            {
               nBuyP = buyP; 
            }
            
            /* selling*/
            
            if(buyP + prices[i] > sellP)
            {
                nSellP = buyP + prices[i] ;
            }
            else
            {
                nSellP = sellP;
            }
            
            /* cooling*/
            
            if(sellP > coolP)
            {
                nCoolP = sellP;
            }
            else
            {
                nCoolP= coolP;
            }
            
            sellP = nSellP;
            buyP = nBuyP;
            coolP = nCoolP;
            
            
        }
        
        return sellP;
        
    }
}
