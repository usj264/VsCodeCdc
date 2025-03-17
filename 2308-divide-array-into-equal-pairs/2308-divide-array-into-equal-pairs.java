class Solution {
    public boolean divideArray(int[] nums) {
        int n=nums.length/2;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i]==nums[i+1])
            {
                n--;
                i++;
            }
        }
        if(n==0){
            return true;}
            else return false;
        }
    }