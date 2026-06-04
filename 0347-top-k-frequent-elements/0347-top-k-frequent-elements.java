class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq =new HashMap<>();
        for(int n:nums){
            freq.put(n,freq.getOrDefault(n,0)+1);
        }

        return freq.entrySet()
               .stream()
               .sorted((a, b) -> b.getValue() - a.getValue())
               .limit(k)
               .mapToInt(e -> e.getKey())
               .toArray();
        
    }
}