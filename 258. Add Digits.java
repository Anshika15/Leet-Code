class Solution {
    public int addDigits(int num) {
        
        while(num > 9)
            num = solve(num);
        return num;
    }
    
    public int solve(int n)
    {
        int sum = 0;
        while (n != 0) 
        {
            sum += n % 10;
            n /= 10;
	    }
	    return sum;
    }
}
