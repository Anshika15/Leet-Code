class Solution {
    public int compareVersion(String version1, String version2) {
        
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        
        int i = 0; int j = 0;
        while(i < arr1.length && j < arr2.length)
        {
            int v1 = Integer.parseInt(arr1[i]);
            int v2 = Integer.parseInt(arr2[i]);
            if(v1 == v2)
            {
                i++;
                j++;
            }
            if(v1 > v2)
                return 1;
            if(v2 > v1)
                return -1;
        }
        
        while(i < arr1.length)
        {
            if(Integer.parseInt(arr1[i]) == 0)
                i++;
            else
                return 1;
        }
        
        while(j < arr2.length)
        {
            if(Integer.parseInt(arr2[j]) == 0)
                j++;
            else
                return -1;
        }
        return 0;
    }
}
