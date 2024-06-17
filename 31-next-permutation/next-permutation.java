class Solution {
    public void nextPermutation(int[] nums) {
        int n=nums.length;
        if(n<2){
            return;
        }
        int k=n-2;
        while(k>=0 && nums[k]>=nums[k+1]){
            k--;
        }

        if(k>=0){
            int l=n-1;
            while(nums[l]<=nums[k]){
                l--;
            }
            swap(nums,k,l);
        }
        reverse(nums,k+1,n-1);
    }
    public void swap(int[] nums, int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int[] nums, int start, int end){
        while(start<end){
            swap(nums,start,end);
            start++;
            end--;
        }
    }
    
}