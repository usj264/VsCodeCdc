class Solution {
    public boolean isAnagram(String s, String t) {
        char[] s1= s.toCharArray();
        char[] t1= t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        String s2= new String(s1);
        String t2= new String(t1);
        if(t2.equals(s2))
        {
            return true;
        }
     else
     {
return false;
     }   
    }
}