class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        
        HashMap<String, HashMap<String, Double>> g = new HashMap<>();
        
        for(int i = 0; i < equations.size(); i++)
        {
            double val = values[i];
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            
            g.putIfAbsent(src, new HashMap<>());
            g.putIfAbsent(dest, new HashMap<>());
            
            g.get(src).put(dest, val);
            g.get(dest).put(src, 1/val);
        }
        
        double[] res = new double[queries.size()];
        
        for(int i = 0; i < queries.size(); i++)
        {
            res[i] = solution(queries.get(i).get(0), queries.get(i).get(1), g, 1.0, new HashSet<>());
        }
        
        return res;
        
    }
    
    double solution(String src, String dest, HashMap<String, HashMap<String, Double>> g, double res, HashSet<String> vis)
    {
        if(vis.contains(src))
            return -1;
        if(!g.containsKey(src))
            return -1;
        if(src.equals(dest))
            return res;
        
        vis.add(src);
        HashMap<String, Double> map = g.get(src);
        
        for(String s : map.keySet())
        {
            double r = solution(s, dest, g, res*map.get(s), vis);
            if(r != -1)
                return r;
        }
        return -1;
        
    }
}
