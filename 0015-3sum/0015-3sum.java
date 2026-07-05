class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    //    Arrays.sort(nums);
    //     Set<List<Integer>> result=new HashSet<>();
    //     for(int i=0;i<nums.length-2;i++){
    //         int left=i+1;
    //         int right=nums.length-1;
    //         while(left<right){
    //             int sum=nums[i]+nums[left]+nums[right];
    //             if(sum==0){
    //                 result.add(Arrays.asList(nums[i],nums[left],nums[right]));
    //                 left++;
    //                 right--;

    //             }
    //             else if(sum<0){
    //                 left++;
    //             }
    //             else{
    //                 right--;
    //             }

    //         }
    //     }

    //     return new ArrayList<>(result);


        
    // }
   

        // Step 1: Sort the array
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // Step 2: Fix the first element with index i
        for (int i = 0; i < nums.length - 2; i++) {

            // Step 3: Skip duplicate values for i
            // (same value as previous i would give same triplets)
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // Step 4: Early exit — if smallest possible sum > 0, no solution possible
            if (nums[i] > 0) break;

            // Step 5: Two pointers on the remaining subarray
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {
                    // ✅ Found a valid triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicates for left pointer
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for right pointer
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers inward
                    left++;
                    right--;

                } else if (sum < 0) {
                    left++;    // Need larger sum

                } else {
                    right--;   // Need smaller sum
                }
            }
        }

        return result;
    
}
}