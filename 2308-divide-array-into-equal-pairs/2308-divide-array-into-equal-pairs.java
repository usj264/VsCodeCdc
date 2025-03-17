class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length/2;
        for(int i=0;i<nums.length;i++)
        {
           for(int j=0;j<nums.length;j++)
           {
            if((nums[i]==nums[j]) && (j!=i) && (nums[j]!=0))
            {
                nums[i]=0;
                nums[j]=0;
                n--;
                break;
            }
            
           }
        }
        if(n==0)
        {
            return true;
        }
        else{
        return false;}
    }
}