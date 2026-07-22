class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>>res=new HashSet<>();

        int n=nums.length;

        for(int i=0; i<n; i++){
            HashSet<Integer>seen=new HashSet<>();

            for(int j=i+1; j<n; j++){
                int third=-(nums[i]+nums[j]);

                if(seen.contains(third)){
                    res.add(Arrays.asList(nums[i],third,nums[j]));
                }
                seen.add(nums[j]);
            }
        }
        return new ArrayList<>(res);
    }
}