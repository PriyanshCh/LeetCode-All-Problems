class Solution {
    public int findNthDigit(int n){
        long digit=1,start=1,count=9;
        while(n>count){
            n-=count;
            digit++;
            start*=10;
            count=9*start*digit;
        }
        long num=start+(n-1)/digit;
        int idx=(int)((n-1)%digit);
        return Long.toString(num).charAt(idx)-'0';
    }
}
