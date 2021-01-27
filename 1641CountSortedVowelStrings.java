class Solution {
    public int countVowelStrings(int n) {
        
        int arr[][] = new int[n+1][6];
        
        for(int i = 0; i < 6; i++)
            arr[1][i] = i;
        
        for(int i = 2; i < n+1; i++)
        {
            for(int j = 1; j < 6; j++)
            {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[n][5];
        
    }
}
