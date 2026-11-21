class Solution {
    public String minWindow(String s, String t) {
        if(t.length()>s.length()){
            return "";

        }
        int[] need=new int[256];
        for(char c:t.toCharArray()){
            need[c]++;
        }

        int required=t.length();
        int minLength=Integer.MAX_VALUE;
        int left=0;
        int startIndex = 0;
        for(int right=0;right<s.length();right++){
            char rightChar=s.charAt(right);

            if(need[rightChar]>0){
                required--;
            }
            need[rightChar]--;
            while(required==0){

                int windowLength=right-left+1;
                if(windowLength<minLength){
                    minLength=windowLength;
                    startIndex = left;
                }

                char leftChar=s.charAt(left);

               need[leftChar]++;

               if(need[leftChar]>0){
                required++;
               }
            
            left++;

            }

        }

       if (minLength == Integer.MAX_VALUE) {
            return "";
        }

       
        return s.substring(startIndex,startIndex+minLength);





        
    }
}