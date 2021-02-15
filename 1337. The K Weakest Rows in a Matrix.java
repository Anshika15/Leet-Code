class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        
       
        for(int i = 0; i < mat.length; i++)
        {
            int c = 0;
            for(int j = 0; j < mat[i].length; j++)
            {
                if(mat[i][j] == 1)
                    c++;
            }
            map.put(i, c);
        }
        
        System.out.println(map);
        
        Map res = sortByValue(map);
        
        System.out.println(res);
        
        int[] arr = new int[k];
        int i = 0;
        
        Iterator<Integer> itr = res.keySet().iterator();
        while (itr.hasNext() && i < k) {
            arr[i] = itr.next();
            i++;
        }
 
        return arr;
        
    }
    
    
    public HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
    
}s
