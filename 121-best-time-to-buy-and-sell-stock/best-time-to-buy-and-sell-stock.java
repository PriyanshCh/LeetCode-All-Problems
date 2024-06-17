class Solution {
    public int maxProfit(int[] arr) {
    int maxProfit=0;
    int minPrice=Integer.MAX_VALUE;
    for(int i=0; i<arr.length; i++){
        minPrice=Math.min(minPrice,arr[i]);
        maxProfit=Math.max(maxProfit,arr[i]-minPrice);
    }
    return maxProfit;
    }
}