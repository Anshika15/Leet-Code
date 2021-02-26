class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++)
        {
            list.add(nums1[i]);
        }
        
        for(int i = 0; i < nums2.length; i++)
        {
            list.add(nums2[i]);
        }
        Collections.sort(list);
        System.out.println(list);
        double var = 0;
        if(list.size() == 0)
            return var;
        if(list.size()%2 != 0)
        {
            int mid = list.size()/2;
            var = list.get(mid);
        }
        else if(list.size()%2 == 0)
        {
           int mid = list.size() / 2;
            double n1 = list.get(mid-1);
            double n2 = list.get(mid);
            var = (n1+n2)/2;
        }
        return var;
        
    }
}
