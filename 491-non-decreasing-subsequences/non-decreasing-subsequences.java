class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> set=new HashSet<>();
        int total=1<<n;
        for(int mask=0;mask<total;mask++){
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0) list.add(nums[i]);
            }
            if(list.size()>=2&&valid(list)) set.add(list);
        }
        return new ArrayList<>(set);
    }
    private boolean valid(List<Integer> list){
        for(int i=1;i<list.size();i++){
            if(list.get(i)<list.get(i-1)) return false;
        }
        return true;
    }
}
