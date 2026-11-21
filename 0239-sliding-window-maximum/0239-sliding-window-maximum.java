class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        Deque<Integer>  deque=new ArrayDeque<Integer>();
        int left=0;
        int[] result=new int[n-k+1];
        for(int right=0;right<n;right++){

            if(!deque.isEmpty() && right-k>=deque.peekFirst()){
                deque.pollFirst();
            }

            while(!deque.isEmpty() && nums[deque.peekLast()]<=nums[right]){
                deque.pollLast();
            }

            deque.offerLast(right);

            if(right>=k-1){
                result[right-k+1]=nums[deque.peekFirst()];
            }


        }
          return result;
    }
}