class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
                
        int indegree[] = new int[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++)
        {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegree[u]++;
        }
        
        LinkedList<Integer> q = new LinkedList<Integer>();
        int res[] = new int[numCourses];
        
        for(int i = 0; i < indegree.length; i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }
        int idx = 0;
       while(q.size() > 0)
       {
           int rem = q.removeFirst();
           res[idx++] = rem;
           
           for(int i = 0; i < prerequisites.length; i++)
           {
               int u = prerequisites[i][0];
               int v = prerequisites[i][1];
               if(v == rem)
               {
                   indegree[u]--;
                   if(indegree[u] == 0)
                       q.add(u);
               }
           }
           
       }
        
       if(idx == numCourses)
           return res;
        return new int[0];
        
    }
    
    
}
