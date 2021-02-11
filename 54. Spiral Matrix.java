class Solution {
    public List<Integer> spiralOrder(int[][] a) {
        
    ArrayList<Integer> list = new ArrayList<>();

	int srow = 0, erow = a.length, scol = 0, ecol = a[0].length;
    
    while(srow < erow && scol < ecol)
    {
    
        for(int i = scol; i < ecol; i++)
        {
            list.add(a[srow][i]);
        }    
        
        srow++;
    
        for(int i = srow; i < erow; i++)
         {
            list.add(a[i][ecol-1]);
         }
        
        ecol--;
    
        if(srow < erow)
        { 
   		    for(int i = ecol-1; i >= scol; i--)
   		    {
     		    list.add(a[erow-1][i]);
   		    }
            
            erow--;
        }
    
        if(scol < ecol)
        {
   		    for(int i = erow-1; i >= srow; i--)
   		    {
     		    list.add(a[i][scol]);
   		    }
            scol++;
        }
    }
    
    return list;
        
  }
}
