import java.util.*;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int n=nums.length;
        // for(int i=0; i<n-1;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{};
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int compliment=target-nums[i];
            if(map.containsKey(compliment)){
                return new int[]{map.get(compliment),i};
            }
            map.put(nums[i],i);
        }
        return new int[] {};
    }
}