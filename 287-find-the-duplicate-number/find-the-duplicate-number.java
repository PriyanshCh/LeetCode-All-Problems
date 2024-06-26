class Solution {
    public int findDuplicate(int[] nums) {
    int i=0;
    while(i<nums.length){
        if(nums[i]!=i+1){
            int correct=nums[i]-1;
            if(correct<nums.length && nums[i]!=nums[correct]){
                swap(nums,i,correct);
            }else{
                return nums[i];
            }
        }else{
            i++;
        }
    }return -1;
    
    // HashSet<Integer> seen = new HashSet<>();
    // for (int num : nums) {
    //     if (seen.contains(num)) {
    //         return num;
    //     }
    //     seen.add(num);
    // }
    // return -1;  // Just to satisfy the compiler, this should never be reached
}
    void swap(int[] nums,int first, int second){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
}